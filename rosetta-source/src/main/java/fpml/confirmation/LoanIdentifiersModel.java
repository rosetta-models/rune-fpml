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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.LoanIdentifiersModel.LoanIdentifiersModelBuilder;
import fpml.confirmation.LoanIdentifiersModel.LoanIdentifiersModelBuilderImpl;
import fpml.confirmation.LoanIdentifiersModel.LoanIdentifiersModelImpl;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.TaskIdentifier;
import fpml.confirmation.meta.LoanIdentifiersModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which contains the identifiers used by loan structures.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanIdentifiersModel", builder=LoanIdentifiersModel.LoanIdentifiersModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanIdentifiersModel extends RosettaModelObject {

	LoanIdentifiersModelMeta metaData = new LoanIdentifiersModelMeta();

	/*********************** Getter Methods  ***********************/
	BusinessEventIdentifier getEventIdentifier();
	OverrideIdentifier getOverrideIdentifier();
	TaskIdentifier getTaskIdentifier();

	/*********************** Build Methods  ***********************/
	LoanIdentifiersModel build();
	
	LoanIdentifiersModel.LoanIdentifiersModelBuilder toBuilder();
	
	static LoanIdentifiersModel.LoanIdentifiersModelBuilder builder() {
		return new LoanIdentifiersModel.LoanIdentifiersModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanIdentifiersModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanIdentifiersModel> getType() {
		return LoanIdentifiersModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("overrideIdentifier"), processor, OverrideIdentifier.class, getOverrideIdentifier());
		processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.class, getTaskIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanIdentifiersModelBuilder extends LoanIdentifiersModel, RosettaModelObjectBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		OverrideIdentifier.OverrideIdentifierBuilder getOrCreateOverrideIdentifier();
		OverrideIdentifier.OverrideIdentifierBuilder getOverrideIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier();
		LoanIdentifiersModel.LoanIdentifiersModelBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		LoanIdentifiersModel.LoanIdentifiersModelBuilder setOverrideIdentifier(OverrideIdentifier overrideIdentifier);
		LoanIdentifiersModel.LoanIdentifiersModelBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("overrideIdentifier"), processor, OverrideIdentifier.OverrideIdentifierBuilder.class, getOverrideIdentifier());
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
		}
		

		LoanIdentifiersModel.LoanIdentifiersModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanIdentifiersModel  ***********************/
	class LoanIdentifiersModelImpl implements LoanIdentifiersModel {
		private final BusinessEventIdentifier eventIdentifier;
		private final OverrideIdentifier overrideIdentifier;
		private final TaskIdentifier taskIdentifier;
		
		protected LoanIdentifiersModelImpl(LoanIdentifiersModel.LoanIdentifiersModelBuilder builder) {
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.overrideIdentifier = ofNullable(builder.getOverrideIdentifier()).map(f->f.build()).orElse(null);
			this.taskIdentifier = ofNullable(builder.getTaskIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("overrideIdentifier")
		public OverrideIdentifier getOverrideIdentifier() {
			return overrideIdentifier;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		public TaskIdentifier getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		public LoanIdentifiersModel build() {
			return this;
		}
		
		@Override
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder toBuilder() {
			LoanIdentifiersModel.LoanIdentifiersModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanIdentifiersModel.LoanIdentifiersModelBuilder builder) {
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getOverrideIdentifier()).ifPresent(builder::setOverrideIdentifier);
			ofNullable(getTaskIdentifier()).ifPresent(builder::setTaskIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanIdentifiersModel _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(overrideIdentifier, _that.getOverrideIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (overrideIdentifier != null ? overrideIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanIdentifiersModel {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"overrideIdentifier=" + this.overrideIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanIdentifiersModel  ***********************/
	class LoanIdentifiersModelBuilderImpl implements LoanIdentifiersModel.LoanIdentifiersModelBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected OverrideIdentifier.OverrideIdentifierBuilder overrideIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder taskIdentifier;
	
		public LoanIdentifiersModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("overrideIdentifier")
		public OverrideIdentifier.OverrideIdentifierBuilder getOverrideIdentifier() {
			return overrideIdentifier;
		}
		
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder getOrCreateOverrideIdentifier() {
			OverrideIdentifier.OverrideIdentifierBuilder result;
			if (overrideIdentifier!=null) {
				result = overrideIdentifier;
			}
			else {
				result = overrideIdentifier = OverrideIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (taskIdentifier!=null) {
				result = taskIdentifier;
			}
			else {
				result = taskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			this.eventIdentifier = eventIdentifier==null?null:eventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("overrideIdentifier")
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder setOverrideIdentifier(OverrideIdentifier overrideIdentifier) {
			this.overrideIdentifier = overrideIdentifier==null?null:overrideIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("taskIdentifier")
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder setTaskIdentifier(TaskIdentifier taskIdentifier) {
			this.taskIdentifier = taskIdentifier==null?null:taskIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public LoanIdentifiersModel build() {
			return new LoanIdentifiersModel.LoanIdentifiersModelImpl(this);
		}
		
		@Override
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder prune() {
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (overrideIdentifier!=null && !overrideIdentifier.prune().hasData()) overrideIdentifier = null;
			if (taskIdentifier!=null && !taskIdentifier.prune().hasData()) taskIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getOverrideIdentifier()!=null && getOverrideIdentifier().hasData()) return true;
			if (getTaskIdentifier()!=null && getTaskIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanIdentifiersModel.LoanIdentifiersModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanIdentifiersModel.LoanIdentifiersModelBuilder o = (LoanIdentifiersModel.LoanIdentifiersModelBuilder) other;
			
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getOverrideIdentifier(), o.getOverrideIdentifier(), this::setOverrideIdentifier);
			merger.mergeRosetta(getTaskIdentifier(), o.getTaskIdentifier(), this::setTaskIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanIdentifiersModel _that = getType().cast(o);
		
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(overrideIdentifier, _that.getOverrideIdentifier())) return false;
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (overrideIdentifier != null ? overrideIdentifier.hashCode() : 0);
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanIdentifiersModelBuilder {" +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"overrideIdentifier=" + this.overrideIdentifier + ", " +
				"taskIdentifier=" + this.taskIdentifier +
			'}';
		}
	}
}
