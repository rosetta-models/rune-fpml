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
import fpml.confirmation.BusinessProcess;
import fpml.confirmation.BusinessProcess.BusinessProcessBuilder;
import fpml.confirmation.BusinessProcess.BusinessProcessBuilderImpl;
import fpml.confirmation.BusinessProcess.BusinessProcessImpl;
import fpml.confirmation.meta.BusinessProcessMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that can be used to identify the type of business process in a request. Examples include Allocation, Clearing, Confirmation, etc.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessProcess", builder=BusinessProcess.BusinessProcessBuilderImpl.class, version="${project.version}")
public interface BusinessProcess extends RosettaModelObject {

	BusinessProcessMeta metaData = new BusinessProcessMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getBusinessProcessScheme();

	/*********************** Build Methods  ***********************/
	BusinessProcess build();
	
	BusinessProcess.BusinessProcessBuilder toBuilder();
	
	static BusinessProcess.BusinessProcessBuilder builder() {
		return new BusinessProcess.BusinessProcessBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessProcess> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessProcess> getType() {
		return BusinessProcess.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("businessProcessScheme"), String.class, getBusinessProcessScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessProcessBuilder extends BusinessProcess, RosettaModelObjectBuilder {
		BusinessProcess.BusinessProcessBuilder setValue(String value);
		BusinessProcess.BusinessProcessBuilder setBusinessProcessScheme(String businessProcessScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("businessProcessScheme"), String.class, getBusinessProcessScheme(), this);
		}
		

		BusinessProcess.BusinessProcessBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessProcess  ***********************/
	class BusinessProcessImpl implements BusinessProcess {
		private final String value;
		private final String businessProcessScheme;
		
		protected BusinessProcessImpl(BusinessProcess.BusinessProcessBuilder builder) {
			this.value = builder.getValue();
			this.businessProcessScheme = builder.getBusinessProcessScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("businessProcessScheme")
		public String getBusinessProcessScheme() {
			return businessProcessScheme;
		}
		
		@Override
		public BusinessProcess build() {
			return this;
		}
		
		@Override
		public BusinessProcess.BusinessProcessBuilder toBuilder() {
			BusinessProcess.BusinessProcessBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessProcess.BusinessProcessBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBusinessProcessScheme()).ifPresent(builder::setBusinessProcessScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessProcess _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(businessProcessScheme, _that.getBusinessProcessScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (businessProcessScheme != null ? businessProcessScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessProcess {" +
				"value=" + this.value + ", " +
				"businessProcessScheme=" + this.businessProcessScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessProcess  ***********************/
	class BusinessProcessBuilderImpl implements BusinessProcess.BusinessProcessBuilder {
	
		protected String value;
		protected String businessProcessScheme;
	
		public BusinessProcessBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("businessProcessScheme")
		public String getBusinessProcessScheme() {
			return businessProcessScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public BusinessProcess.BusinessProcessBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("businessProcessScheme")
		public BusinessProcess.BusinessProcessBuilder setBusinessProcessScheme(String businessProcessScheme) {
			this.businessProcessScheme = businessProcessScheme==null?null:businessProcessScheme;
			return this;
		}
		
		@Override
		public BusinessProcess build() {
			return new BusinessProcess.BusinessProcessImpl(this);
		}
		
		@Override
		public BusinessProcess.BusinessProcessBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessProcess.BusinessProcessBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBusinessProcessScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessProcess.BusinessProcessBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessProcess.BusinessProcessBuilder o = (BusinessProcess.BusinessProcessBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBusinessProcessScheme(), o.getBusinessProcessScheme(), this::setBusinessProcessScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessProcess _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(businessProcessScheme, _that.getBusinessProcessScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (businessProcessScheme != null ? businessProcessScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessProcessBuilder {" +
				"value=" + this.value + ", " +
				"businessProcessScheme=" + this.businessProcessScheme +
			'}';
		}
	}
}
