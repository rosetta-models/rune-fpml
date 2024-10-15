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
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TaskId;
import fpml.confirmation.TaskIdentifier;
import fpml.confirmation.TaskIdentifier.TaskIdentifierBuilder;
import fpml.confirmation.TaskIdentifier.TaskIdentifierBuilderImpl;
import fpml.confirmation.TaskIdentifier.TaskIdentifierImpl;
import fpml.confirmation.meta.TaskIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a task identifier issued by the indicated party.
 * @version ${project.version}
 */
@RosettaDataType(value="TaskIdentifier", builder=TaskIdentifier.TaskIdentifierBuilderImpl.class, version="${project.version}")
public interface TaskIdentifier extends RosettaModelObject {

	TaskIdentifierMeta metaData = new TaskIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	TaskId getTaskId();
	String getId();

	/*********************** Build Methods  ***********************/
	TaskIdentifier build();
	
	TaskIdentifier.TaskIdentifierBuilder toBuilder();
	
	static TaskIdentifier.TaskIdentifierBuilder builder() {
		return new TaskIdentifier.TaskIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaskIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TaskIdentifier> getType() {
		return TaskIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("taskId"), processor, TaskId.class, getTaskId());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaskIdentifierBuilder extends TaskIdentifier, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		TaskId.TaskIdBuilder getOrCreateTaskId();
		TaskId.TaskIdBuilder getTaskId();
		TaskIdentifier.TaskIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		TaskIdentifier.TaskIdentifierBuilder setTaskId(TaskId taskId);
		TaskIdentifier.TaskIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("taskId"), processor, TaskId.TaskIdBuilder.class, getTaskId());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		TaskIdentifier.TaskIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of TaskIdentifier  ***********************/
	class TaskIdentifierImpl implements TaskIdentifier {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final TaskId taskId;
		private final String id;
		
		protected TaskIdentifierImpl(TaskIdentifier.TaskIdentifierBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.taskId = ofNullable(builder.getTaskId()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("taskId")
		public TaskId getTaskId() {
			return taskId;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public TaskIdentifier build() {
			return this;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder toBuilder() {
			TaskIdentifier.TaskIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaskIdentifier.TaskIdentifierBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getTaskId()).ifPresent(builder::setTaskId);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(taskId, _that.getTaskId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (taskId != null ? taskId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskIdentifier {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"taskId=" + this.taskId + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of TaskIdentifier  ***********************/
	class TaskIdentifierBuilderImpl implements TaskIdentifier.TaskIdentifierBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected TaskId.TaskIdBuilder taskId;
		protected String id;
	
		public TaskIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder result;
			if (partyAndAccountReferencesModel!=null) {
				result = partyAndAccountReferencesModel;
			}
			else {
				result = partyAndAccountReferencesModel = PartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taskId")
		public TaskId.TaskIdBuilder getTaskId() {
			return taskId;
		}
		
		@Override
		public TaskId.TaskIdBuilder getOrCreateTaskId() {
			TaskId.TaskIdBuilder result;
			if (taskId!=null) {
				result = taskId;
			}
			else {
				result = taskId = TaskId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public TaskIdentifier.TaskIdentifierBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("taskId")
		public TaskIdentifier.TaskIdentifierBuilder setTaskId(TaskId taskId) {
			this.taskId = taskId==null?null:taskId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TaskIdentifier.TaskIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public TaskIdentifier build() {
			return new TaskIdentifier.TaskIdentifierImpl(this);
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			if (taskId!=null && !taskId.prune().hasData()) taskId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getTaskId()!=null && getTaskId().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaskIdentifier.TaskIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaskIdentifier.TaskIdentifierBuilder o = (TaskIdentifier.TaskIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getTaskId(), o.getTaskId(), this::setTaskId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaskIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(taskId, _that.getTaskId())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (taskId != null ? taskId.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaskIdentifierBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"taskId=" + this.taskId + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
