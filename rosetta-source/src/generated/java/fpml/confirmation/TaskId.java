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
import fpml.confirmation.TaskId;
import fpml.confirmation.TaskId.TaskIdBuilder;
import fpml.confirmation.TaskId.TaskIdBuilderImpl;
import fpml.confirmation.TaskId.TaskIdImpl;
import fpml.confirmation.meta.TaskIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines a task identifier based on a qualifying scheme.
 * @version ${project.version}
 */
@RosettaDataType(value="TaskId", builder=TaskId.TaskIdBuilderImpl.class, version="${project.version}")
public interface TaskId extends RosettaModelObject {

	TaskIdMeta metaData = new TaskIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTaskIdScheme();

	/*********************** Build Methods  ***********************/
	TaskId build();
	
	TaskId.TaskIdBuilder toBuilder();
	
	static TaskId.TaskIdBuilder builder() {
		return new TaskId.TaskIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaskId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TaskId> getType() {
		return TaskId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("taskIdScheme"), String.class, getTaskIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaskIdBuilder extends TaskId, RosettaModelObjectBuilder {
		TaskId.TaskIdBuilder setValue(String value);
		TaskId.TaskIdBuilder setTaskIdScheme(String taskIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("taskIdScheme"), String.class, getTaskIdScheme(), this);
		}
		

		TaskId.TaskIdBuilder prune();
	}

	/*********************** Immutable Implementation of TaskId  ***********************/
	class TaskIdImpl implements TaskId {
		private final String value;
		private final String taskIdScheme;
		
		protected TaskIdImpl(TaskId.TaskIdBuilder builder) {
			this.value = builder.getValue();
			this.taskIdScheme = builder.getTaskIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("taskIdScheme")
		public String getTaskIdScheme() {
			return taskIdScheme;
		}
		
		@Override
		public TaskId build() {
			return this;
		}
		
		@Override
		public TaskId.TaskIdBuilder toBuilder() {
			TaskId.TaskIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaskId.TaskIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTaskIdScheme()).ifPresent(builder::setTaskIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(taskIdScheme, _that.getTaskIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (taskIdScheme != null ? taskIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskId {" +
				"value=" + this.value + ", " +
				"taskIdScheme=" + this.taskIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TaskId  ***********************/
	class TaskIdBuilderImpl implements TaskId.TaskIdBuilder {
	
		protected String value;
		protected String taskIdScheme;
	
		public TaskIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("taskIdScheme")
		public String getTaskIdScheme() {
			return taskIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TaskId.TaskIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("taskIdScheme")
		public TaskId.TaskIdBuilder setTaskIdScheme(String taskIdScheme) {
			this.taskIdScheme = taskIdScheme==null?null:taskIdScheme;
			return this;
		}
		
		@Override
		public TaskId build() {
			return new TaskId.TaskIdImpl(this);
		}
		
		@Override
		public TaskId.TaskIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskId.TaskIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTaskIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskId.TaskIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaskId.TaskIdBuilder o = (TaskId.TaskIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTaskIdScheme(), o.getTaskIdScheme(), this::setTaskIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(taskIdScheme, _that.getTaskIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (taskIdScheme != null ? taskIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskIdBuilder {" +
				"value=" + this.value + ", " +
				"taskIdScheme=" + this.taskIdScheme +
			'}';
		}
	}
}
