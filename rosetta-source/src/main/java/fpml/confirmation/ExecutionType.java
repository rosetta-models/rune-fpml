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
import fpml.confirmation.ExecutionType;
import fpml.confirmation.ExecutionType.ExecutionTypeBuilder;
import fpml.confirmation.ExecutionType.ExecutionTypeBuilderImpl;
import fpml.confirmation.ExecutionType.ExecutionTypeImpl;
import fpml.confirmation.meta.ExecutionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type used to represent the type of market where a trade can be executed.
 * @version ${project.version}
 */
@RosettaDataType(value="ExecutionType", builder=ExecutionType.ExecutionTypeBuilderImpl.class, version="${project.version}")
public interface ExecutionType extends RosettaModelObject {

	ExecutionTypeMeta metaData = new ExecutionTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getExecutionTypeScheme();

	/*********************** Build Methods  ***********************/
	ExecutionType build();
	
	ExecutionType.ExecutionTypeBuilder toBuilder();
	
	static ExecutionType.ExecutionTypeBuilder builder() {
		return new ExecutionType.ExecutionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionType> getType() {
		return ExecutionType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("executionTypeScheme"), String.class, getExecutionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionTypeBuilder extends ExecutionType, RosettaModelObjectBuilder {
		ExecutionType.ExecutionTypeBuilder setValue(String value);
		ExecutionType.ExecutionTypeBuilder setExecutionTypeScheme(String executionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("executionTypeScheme"), String.class, getExecutionTypeScheme(), this);
		}
		

		ExecutionType.ExecutionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionType  ***********************/
	class ExecutionTypeImpl implements ExecutionType {
		private final String value;
		private final String executionTypeScheme;
		
		protected ExecutionTypeImpl(ExecutionType.ExecutionTypeBuilder builder) {
			this.value = builder.getValue();
			this.executionTypeScheme = builder.getExecutionTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionTypeScheme")
		public String getExecutionTypeScheme() {
			return executionTypeScheme;
		}
		
		@Override
		public ExecutionType build() {
			return this;
		}
		
		@Override
		public ExecutionType.ExecutionTypeBuilder toBuilder() {
			ExecutionType.ExecutionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionType.ExecutionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExecutionTypeScheme()).ifPresent(builder::setExecutionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionTypeScheme, _that.getExecutionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionTypeScheme != null ? executionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionType {" +
				"value=" + this.value + ", " +
				"executionTypeScheme=" + this.executionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionType  ***********************/
	class ExecutionTypeBuilderImpl implements ExecutionType.ExecutionTypeBuilder {
	
		protected String value;
		protected String executionTypeScheme;
	
		public ExecutionTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionTypeScheme")
		public String getExecutionTypeScheme() {
			return executionTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ExecutionType.ExecutionTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("executionTypeScheme")
		public ExecutionType.ExecutionTypeBuilder setExecutionTypeScheme(String executionTypeScheme) {
			this.executionTypeScheme = executionTypeScheme==null?null:executionTypeScheme;
			return this;
		}
		
		@Override
		public ExecutionType build() {
			return new ExecutionType.ExecutionTypeImpl(this);
		}
		
		@Override
		public ExecutionType.ExecutionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionType.ExecutionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExecutionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionType.ExecutionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionType.ExecutionTypeBuilder o = (ExecutionType.ExecutionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExecutionTypeScheme(), o.getExecutionTypeScheme(), this::setExecutionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionTypeScheme, _that.getExecutionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionTypeScheme != null ? executionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionTypeBuilder {" +
				"value=" + this.value + ", " +
				"executionTypeScheme=" + this.executionTypeScheme +
			'}';
		}
	}
}
