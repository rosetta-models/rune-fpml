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
import fpml.confirmation.ServiceProcessingCycle;
import fpml.confirmation.ServiceProcessingCycle.ServiceProcessingCycleBuilder;
import fpml.confirmation.ServiceProcessingCycle.ServiceProcessingCycleBuilderImpl;
import fpml.confirmation.ServiceProcessingCycle.ServiceProcessingCycleImpl;
import fpml.confirmation.meta.ServiceProcessingCycleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that can be used to describe the processing phase of a service. For example, EndOfDay, Intraday.
 * @version ${project.version}
 */
@RosettaDataType(value="ServiceProcessingCycle", builder=ServiceProcessingCycle.ServiceProcessingCycleBuilderImpl.class, version="${project.version}")
public interface ServiceProcessingCycle extends RosettaModelObject {

	ServiceProcessingCycleMeta metaData = new ServiceProcessingCycleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getServiceProcessingCycleScheme();

	/*********************** Build Methods  ***********************/
	ServiceProcessingCycle build();
	
	ServiceProcessingCycle.ServiceProcessingCycleBuilder toBuilder();
	
	static ServiceProcessingCycle.ServiceProcessingCycleBuilder builder() {
		return new ServiceProcessingCycle.ServiceProcessingCycleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceProcessingCycle> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ServiceProcessingCycle> getType() {
		return ServiceProcessingCycle.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("serviceProcessingCycleScheme"), String.class, getServiceProcessingCycleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceProcessingCycleBuilder extends ServiceProcessingCycle, RosettaModelObjectBuilder {
		ServiceProcessingCycle.ServiceProcessingCycleBuilder setValue(String value);
		ServiceProcessingCycle.ServiceProcessingCycleBuilder setServiceProcessingCycleScheme(String serviceProcessingCycleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("serviceProcessingCycleScheme"), String.class, getServiceProcessingCycleScheme(), this);
		}
		

		ServiceProcessingCycle.ServiceProcessingCycleBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceProcessingCycle  ***********************/
	class ServiceProcessingCycleImpl implements ServiceProcessingCycle {
		private final String value;
		private final String serviceProcessingCycleScheme;
		
		protected ServiceProcessingCycleImpl(ServiceProcessingCycle.ServiceProcessingCycleBuilder builder) {
			this.value = builder.getValue();
			this.serviceProcessingCycleScheme = builder.getServiceProcessingCycleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("serviceProcessingCycleScheme")
		public String getServiceProcessingCycleScheme() {
			return serviceProcessingCycleScheme;
		}
		
		@Override
		public ServiceProcessingCycle build() {
			return this;
		}
		
		@Override
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder toBuilder() {
			ServiceProcessingCycle.ServiceProcessingCycleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceProcessingCycle.ServiceProcessingCycleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getServiceProcessingCycleScheme()).ifPresent(builder::setServiceProcessingCycleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingCycle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceProcessingCycleScheme, _that.getServiceProcessingCycleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceProcessingCycleScheme != null ? serviceProcessingCycleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingCycle {" +
				"value=" + this.value + ", " +
				"serviceProcessingCycleScheme=" + this.serviceProcessingCycleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceProcessingCycle  ***********************/
	class ServiceProcessingCycleBuilderImpl implements ServiceProcessingCycle.ServiceProcessingCycleBuilder {
	
		protected String value;
		protected String serviceProcessingCycleScheme;
	
		public ServiceProcessingCycleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("serviceProcessingCycleScheme")
		public String getServiceProcessingCycleScheme() {
			return serviceProcessingCycleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("serviceProcessingCycleScheme")
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder setServiceProcessingCycleScheme(String serviceProcessingCycleScheme) {
			this.serviceProcessingCycleScheme = serviceProcessingCycleScheme==null?null:serviceProcessingCycleScheme;
			return this;
		}
		
		@Override
		public ServiceProcessingCycle build() {
			return new ServiceProcessingCycle.ServiceProcessingCycleImpl(this);
		}
		
		@Override
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getServiceProcessingCycleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceProcessingCycle.ServiceProcessingCycleBuilder o = (ServiceProcessingCycle.ServiceProcessingCycleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getServiceProcessingCycleScheme(), o.getServiceProcessingCycleScheme(), this::setServiceProcessingCycleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingCycle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(serviceProcessingCycleScheme, _that.getServiceProcessingCycleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (serviceProcessingCycleScheme != null ? serviceProcessingCycleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingCycleBuilder {" +
				"value=" + this.value + ", " +
				"serviceProcessingCycleScheme=" + this.serviceProcessingCycleScheme +
			'}';
		}
	}
}
