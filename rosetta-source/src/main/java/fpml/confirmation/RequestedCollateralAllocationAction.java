package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.RequestedCollateralAllocationAction;
import fpml.confirmation.RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder;
import fpml.confirmation.RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilderImpl;
import fpml.confirmation.RequestedCollateralAllocationAction.RequestedCollateralAllocationActionImpl;
import fpml.confirmation.meta.RequestedCollateralAllocationActionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the type of collateral allocation action that is requested. The purpose is to allow FCMs to specify how the allocations are to be processed.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RequestedCollateralAllocationAction", builder=RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RequestedCollateralAllocationAction extends RosettaModelObject {

	RequestedCollateralAllocationActionMeta metaData = new RequestedCollateralAllocationActionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRequestedCollateralAllocationActionScheme();

	/*********************** Build Methods  ***********************/
	RequestedCollateralAllocationAction build();
	
	RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder toBuilder();
	
	static RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder builder() {
		return new RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestedCollateralAllocationAction> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestedCollateralAllocationAction> getType() {
		return RequestedCollateralAllocationAction.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("requestedCollateralAllocationActionScheme"), String.class, getRequestedCollateralAllocationActionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestedCollateralAllocationActionBuilder extends RequestedCollateralAllocationAction, RosettaModelObjectBuilder {
		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder setValue(String value);
		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder setRequestedCollateralAllocationActionScheme(String requestedCollateralAllocationActionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("requestedCollateralAllocationActionScheme"), String.class, getRequestedCollateralAllocationActionScheme(), this);
		}
		

		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestedCollateralAllocationAction  ***********************/
	class RequestedCollateralAllocationActionImpl implements RequestedCollateralAllocationAction {
		private final String value;
		private final String requestedCollateralAllocationActionScheme;
		
		protected RequestedCollateralAllocationActionImpl(RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder builder) {
			this.value = builder.getValue();
			this.requestedCollateralAllocationActionScheme = builder.getRequestedCollateralAllocationActionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("requestedCollateralAllocationActionScheme")
		public String getRequestedCollateralAllocationActionScheme() {
			return requestedCollateralAllocationActionScheme;
		}
		
		@Override
		public RequestedCollateralAllocationAction build() {
			return this;
		}
		
		@Override
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder toBuilder() {
			RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRequestedCollateralAllocationActionScheme()).ifPresent(builder::setRequestedCollateralAllocationActionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedCollateralAllocationAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedCollateralAllocationActionScheme, _that.getRequestedCollateralAllocationActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedCollateralAllocationActionScheme != null ? requestedCollateralAllocationActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedCollateralAllocationAction {" +
				"value=" + this.value + ", " +
				"requestedCollateralAllocationActionScheme=" + this.requestedCollateralAllocationActionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RequestedCollateralAllocationAction  ***********************/
	class RequestedCollateralAllocationActionBuilderImpl implements RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder {
	
		protected String value;
		protected String requestedCollateralAllocationActionScheme;
	
		public RequestedCollateralAllocationActionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("requestedCollateralAllocationActionScheme")
		public String getRequestedCollateralAllocationActionScheme() {
			return requestedCollateralAllocationActionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("requestedCollateralAllocationActionScheme")
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder setRequestedCollateralAllocationActionScheme(String requestedCollateralAllocationActionScheme) {
			this.requestedCollateralAllocationActionScheme = requestedCollateralAllocationActionScheme==null?null:requestedCollateralAllocationActionScheme;
			return this;
		}
		
		@Override
		public RequestedCollateralAllocationAction build() {
			return new RequestedCollateralAllocationAction.RequestedCollateralAllocationActionImpl(this);
		}
		
		@Override
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRequestedCollateralAllocationActionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder o = (RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRequestedCollateralAllocationActionScheme(), o.getRequestedCollateralAllocationActionScheme(), this::setRequestedCollateralAllocationActionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedCollateralAllocationAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedCollateralAllocationActionScheme, _that.getRequestedCollateralAllocationActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedCollateralAllocationActionScheme != null ? requestedCollateralAllocationActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedCollateralAllocationActionBuilder {" +
				"value=" + this.value + ", " +
				"requestedCollateralAllocationActionScheme=" + this.requestedCollateralAllocationActionScheme +
			'}';
		}
	}
}
