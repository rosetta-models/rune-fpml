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
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.ExecutionDateTime.ExecutionDateTimeBuilder;
import fpml.confirmation.ExecutionDateTime.ExecutionDateTimeBuilderImpl;
import fpml.confirmation.ExecutionDateTime.ExecutionDateTimeImpl;
import fpml.confirmation.meta.ExecutionDateTimeMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the trade execution date time and the source of it. For use inside containing types which already have a Reference to a Party that has assigned this trade execution date time.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExecutionDateTime", builder=ExecutionDateTime.ExecutionDateTimeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExecutionDateTime extends RosettaModelObject {

	ExecutionDateTimeMeta metaData = new ExecutionDateTimeMeta();

	/*********************** Getter Methods  ***********************/
	ZonedDateTime getValue();
	/**
	 * Identification of the source (e.g. clock id) generating the execution date time.
	 */
	String getExecutionDateTimeScheme();

	/*********************** Build Methods  ***********************/
	ExecutionDateTime build();
	
	ExecutionDateTime.ExecutionDateTimeBuilder toBuilder();
	
	static ExecutionDateTime.ExecutionDateTimeBuilder builder() {
		return new ExecutionDateTime.ExecutionDateTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionDateTime> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExecutionDateTime> getType() {
		return ExecutionDateTime.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
		processor.processBasic(path.newSubPath("executionDateTimeScheme"), String.class, getExecutionDateTimeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionDateTimeBuilder extends ExecutionDateTime, RosettaModelObjectBuilder {
		ExecutionDateTime.ExecutionDateTimeBuilder setValue(ZonedDateTime value);
		ExecutionDateTime.ExecutionDateTimeBuilder setExecutionDateTimeScheme(String executionDateTimeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
			processor.processBasic(path.newSubPath("executionDateTimeScheme"), String.class, getExecutionDateTimeScheme(), this);
		}
		

		ExecutionDateTime.ExecutionDateTimeBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionDateTime  ***********************/
	class ExecutionDateTimeImpl implements ExecutionDateTime {
		private final ZonedDateTime value;
		private final String executionDateTimeScheme;
		
		protected ExecutionDateTimeImpl(ExecutionDateTime.ExecutionDateTimeBuilder builder) {
			this.value = builder.getValue();
			this.executionDateTimeScheme = builder.getExecutionDateTimeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionDateTimeScheme")
		public String getExecutionDateTimeScheme() {
			return executionDateTimeScheme;
		}
		
		@Override
		public ExecutionDateTime build() {
			return this;
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder toBuilder() {
			ExecutionDateTime.ExecutionDateTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionDateTime.ExecutionDateTimeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExecutionDateTimeScheme()).ifPresent(builder::setExecutionDateTimeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionDateTime _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionDateTimeScheme, _that.getExecutionDateTimeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionDateTimeScheme != null ? executionDateTimeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionDateTime {" +
				"value=" + this.value + ", " +
				"executionDateTimeScheme=" + this.executionDateTimeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionDateTime  ***********************/
	class ExecutionDateTimeBuilderImpl implements ExecutionDateTime.ExecutionDateTimeBuilder {
	
		protected ZonedDateTime value;
		protected String executionDateTimeScheme;
	
		public ExecutionDateTimeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("executionDateTimeScheme")
		public String getExecutionDateTimeScheme() {
			return executionDateTimeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ExecutionDateTime.ExecutionDateTimeBuilder setValue(ZonedDateTime value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("executionDateTimeScheme")
		public ExecutionDateTime.ExecutionDateTimeBuilder setExecutionDateTimeScheme(String executionDateTimeScheme) {
			this.executionDateTimeScheme = executionDateTimeScheme==null?null:executionDateTimeScheme;
			return this;
		}
		
		@Override
		public ExecutionDateTime build() {
			return new ExecutionDateTime.ExecutionDateTimeImpl(this);
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExecutionDateTimeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionDateTime.ExecutionDateTimeBuilder o = (ExecutionDateTime.ExecutionDateTimeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExecutionDateTimeScheme(), o.getExecutionDateTimeScheme(), this::setExecutionDateTimeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionDateTime _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(executionDateTimeScheme, _that.getExecutionDateTimeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (executionDateTimeScheme != null ? executionDateTimeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionDateTimeBuilder {" +
				"value=" + this.value + ", " +
				"executionDateTimeScheme=" + this.executionDateTimeScheme +
			'}';
		}
	}
}
