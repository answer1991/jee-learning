package com.answer1991.servlet.asyc;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ejb.EJB;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer1991.servlet.ejb.PriceVolumeBean;

/**
 * Servlet implementation class PriceVolumeBean
 */
@WebServlet(urlPatterns = "/PriceVolumeBean", asyncSupported = true, loadOnStartup = 1)
public class PriceVolumeServlet extends HttpServlet {
	
	private ConcurrentLinkedQueue<AsyncContext> cxtList;
	
	@EJB
	private PriceVolumeBean priceVolumeBean;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceVolumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	cxtList = new ConcurrentLinkedQueue<AsyncContext>();
    	priceVolumeBean.setServlet(this);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext cxt = request.startAsync();
		cxt.addListener(new AsyncListener() {
			
			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				cxtList.remove(cxt);
			}
			
			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				
			}
			
			@Override
			public void onError(AsyncEvent event) throws IOException {
				cxtList.remove(cxt);
			}
			
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				cxtList.remove(cxt);
			}
		});
		
		cxtList.add(cxt);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public ConcurrentLinkedQueue<AsyncContext> getAsyncCxtList() {
		return this.cxtList;
	}

	public void sendTimeToAllRequest() {
		for(AsyncContext cxt : cxtList) {
			try {
				cxt.getResponse().getWriter().append(new Date().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				cxt.complete();
			}
		}
	}
}
