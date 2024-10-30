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
import fpml.confirmation.ExecutionVenueType;
import fpml.confirmation.ExecutionVenueType.ExecutionVenueTypeBuilder;
import fpml.confirmation.ExecutionVenueType.ExecutionVenueTypeBuilderImpl;
import fpml.confirmation.ExecutionVenueType.ExecutionVenueTypeImpl;
import fpml.confirmation.meta.ExecutionVenueTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type used to represent the type of market where a trade can be executed.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExecutionVenueType", builder=ExecutionVenueType.ExecutionVenueTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExecutionVenueType extends RosettaModelObject {

	ExecutionVenueTypeMeta metaData = new ExecutionVenueTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getExecutionVenueTypeScheme();

	/*********************** Build Methods  ***********************/
	ExecutionVenueType build();
	
	ExecutionVenueType.ExecutionVenueTypeBuilder toBuilder();
	
	static ExecutionVenueType.ExecutionVenueTypeBuilder builder() {
		return new ExecutionVenueType.ExecutionVenueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionVenueType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionVenueType> getType() {
		return ExecutionVenueType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("executionVenueTypeScheme"), String.class, getExecutionVenueTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionVenueTypeBuilder extends ExecutionVenueType, RosettaModelObjectBuilder {
		ExecutionVenueType.ExecutionVenueTypeBuilder setValue(String value);
		ExecutionVenueType.ExecutionVenueTypeBuilder setExecutionVenueTypeScheme(String executionVenueTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("executionVenueTypeScheme"), String.class, getExecutionVenueTypeScheme(), this);
		}
		

		ExecutionVenueType.ExecutionVenueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionVenueType  ***********************/
	class ExecutionVenueTypeImpl implements ExecutionVenueType {
		private final String value;
		private final String executionVenueTypeScheme;
		
		protected ExecutionVenueTypeImpl(ExecutionVenueType.ExecutionVenueTypeBuilder builder) {
			this.value = builder.getValue();
			this.executionVenueTypeScheme = builder.getExecutionVenueTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionVenueTypeScheme")
		public String getExecutionVenueTypeScheme() {
			return executionVenueTypeScheme;
		}
		
		@Override
		public ExecutionVenueType build() {
			return this;
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder toBuilder() {
			ExecutionVenueType.ExecutionVenueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionVenueType.ExecutionVenueTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExecutionVenueTypeScheme()).ifPresent(builder::setExecutionVenueTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionVenueType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionVenueTypeScheme, _that.getExecutionVenueTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionVenueTypeScheme != null ? executionVenueTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionVenueType {" +
				"value=" + this.value + ", " +
				"executionVenueTypeScheme=" + this.executionVenueTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionVenueType  ***********************/
	class ExecutionVenueTypeBuilderImpl implements ExecutionVenueType.ExecutionVenueTypeBuilder {
	
		protected String value;
		protected String executionVenueTypeScheme;
	
		public ExecutionVenueTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionVenueTypeScheme")
		public String getExecutionVenueTypeScheme() {
			return executionVenueTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ExecutionVenueType.ExecutionVenueTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("executionVenueTypeScheme")
		public ExecutionVenueType.ExecutionVenueTypeBuilder setExecutionVenueTypeScheme(String executionVenueTypeScheme) {
			this.executionVenueTypeScheme = executionVenueTypeScheme==null?null:executionVenueTypeScheme;
			return this;
		}
		
		@Override
		public ExecutionVenueType build() {
			return new ExecutionVenueType.ExecutionVenueTypeImpl(this);
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExecutionVenueTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionVenueType.ExecutionVenueTypeBuilder o = (ExecutionVenueType.ExecutionVenueTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExecutionVenueTypeScheme(), o.getExecutionVenueTypeScheme(), this::setExecutionVenueTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionVenueType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionVenueTypeScheme, _that.getExecutionVenueTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionVenueTypeScheme != null ? executionVenueTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionVenueTypeBuilder {" +
				"value=" + this.value + ", " +
				"executionVenueTypeScheme=" + this.executionVenueTypeScheme +
			'}';
		}
	}
}
