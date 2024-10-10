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
import fpml.confirmation.RequestedClearingAction;
import fpml.confirmation.RequestedClearingAction.RequestedClearingActionBuilder;
import fpml.confirmation.RequestedClearingAction.RequestedClearingActionBuilderImpl;
import fpml.confirmation.RequestedClearingAction.RequestedClearingActionImpl;
import fpml.confirmation.meta.RequestedClearingActionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes whether a trade is to be cleared.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestedClearingAction", builder=RequestedClearingAction.RequestedClearingActionBuilderImpl.class, version="${project.version}")
public interface RequestedClearingAction extends RosettaModelObject {

	RequestedClearingActionMeta metaData = new RequestedClearingActionMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRequestedClearingActionScheme();

	/*********************** Build Methods  ***********************/
	RequestedClearingAction build();
	
	RequestedClearingAction.RequestedClearingActionBuilder toBuilder();
	
	static RequestedClearingAction.RequestedClearingActionBuilder builder() {
		return new RequestedClearingAction.RequestedClearingActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestedClearingAction> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestedClearingAction> getType() {
		return RequestedClearingAction.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("requestedClearingActionScheme"), String.class, getRequestedClearingActionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestedClearingActionBuilder extends RequestedClearingAction, RosettaModelObjectBuilder {
		RequestedClearingAction.RequestedClearingActionBuilder setValue(String value);
		RequestedClearingAction.RequestedClearingActionBuilder setRequestedClearingActionScheme(String requestedClearingActionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("requestedClearingActionScheme"), String.class, getRequestedClearingActionScheme(), this);
		}
		

		RequestedClearingAction.RequestedClearingActionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestedClearingAction  ***********************/
	class RequestedClearingActionImpl implements RequestedClearingAction {
		private final String value;
		private final String requestedClearingActionScheme;
		
		protected RequestedClearingActionImpl(RequestedClearingAction.RequestedClearingActionBuilder builder) {
			this.value = builder.getValue();
			this.requestedClearingActionScheme = builder.getRequestedClearingActionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("requestedClearingActionScheme")
		public String getRequestedClearingActionScheme() {
			return requestedClearingActionScheme;
		}
		
		@Override
		public RequestedClearingAction build() {
			return this;
		}
		
		@Override
		public RequestedClearingAction.RequestedClearingActionBuilder toBuilder() {
			RequestedClearingAction.RequestedClearingActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestedClearingAction.RequestedClearingActionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRequestedClearingActionScheme()).ifPresent(builder::setRequestedClearingActionScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedClearingAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedClearingActionScheme, _that.getRequestedClearingActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedClearingActionScheme != null ? requestedClearingActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedClearingAction {" +
				"value=" + this.value + ", " +
				"requestedClearingActionScheme=" + this.requestedClearingActionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RequestedClearingAction  ***********************/
	class RequestedClearingActionBuilderImpl implements RequestedClearingAction.RequestedClearingActionBuilder {
	
		protected String value;
		protected String requestedClearingActionScheme;
	
		public RequestedClearingActionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("requestedClearingActionScheme")
		public String getRequestedClearingActionScheme() {
			return requestedClearingActionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public RequestedClearingAction.RequestedClearingActionBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("requestedClearingActionScheme")
		public RequestedClearingAction.RequestedClearingActionBuilder setRequestedClearingActionScheme(String requestedClearingActionScheme) {
			this.requestedClearingActionScheme = requestedClearingActionScheme==null?null:requestedClearingActionScheme;
			return this;
		}
		
		@Override
		public RequestedClearingAction build() {
			return new RequestedClearingAction.RequestedClearingActionImpl(this);
		}
		
		@Override
		public RequestedClearingAction.RequestedClearingActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedClearingAction.RequestedClearingActionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRequestedClearingActionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestedClearingAction.RequestedClearingActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RequestedClearingAction.RequestedClearingActionBuilder o = (RequestedClearingAction.RequestedClearingActionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRequestedClearingActionScheme(), o.getRequestedClearingActionScheme(), this::setRequestedClearingActionScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequestedClearingAction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(requestedClearingActionScheme, _that.getRequestedClearingActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (requestedClearingActionScheme != null ? requestedClearingActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestedClearingActionBuilder {" +
				"value=" + this.value + ", " +
				"requestedClearingActionScheme=" + this.requestedClearingActionScheme +
			'}';
		}
	}
}
