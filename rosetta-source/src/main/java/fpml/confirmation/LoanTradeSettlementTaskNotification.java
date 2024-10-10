package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanTradeSettlementTask;
import fpml.confirmation.LoanTradeSettlementTaskNotification;
import fpml.confirmation.LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder;
import fpml.confirmation.LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilderImpl;
import fpml.confirmation.LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationImpl;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTradeSettlementTaskNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate master trade-level tasks and their statuses, the completion of which are deemed by the sender of the notification to be prerequisites to the settlement of a trade or allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeSettlementTaskNotification", builder=LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilderImpl.class, version="${project.version}")
public interface LoanTradeSettlementTaskNotification extends AbstractLoanTradingNotification {

	LoanTradeSettlementTaskNotificationMeta metaData = new LoanTradeSettlementTaskNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The task, which is a prerequisite to trade settlement.
	 */
	List<? extends LoanTradeSettlementTask> getTask();
	/**
	 * A summary of the master trade.
	 */
	List<? extends LoanTradeSummary> getTradeSummary();
	List<? extends FacilityDetailsModel> getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTradeSettlementTaskNotification build();
	
	LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder toBuilder();
	
	static LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder builder() {
		return new LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeSettlementTaskNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeSettlementTaskNotification> getType() {
		return LoanTradeSettlementTaskNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
		processRosetta(path.newSubPath("task"), processor, LoanTradeSettlementTask.class, getTask());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeSettlementTaskNotificationBuilder extends LoanTradeSettlementTaskNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder getOrCreateTask(int _index);
		List<? extends LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder> getTask();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary(int _index);
		List<? extends LoanTradeSummary.LoanTradeSummaryBuilder> getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index);
		List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTask(LoanTradeSettlementTask task0);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTask(LoanTradeSettlementTask task1, int _idx);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTask(List<? extends LoanTradeSettlementTask> task2);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setTask(List<? extends LoanTradeSettlementTask> task3);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary0);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary1, int _idx);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTradeSummary(List<? extends LoanTradeSummary> tradeSummary2);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setTradeSummary(List<? extends LoanTradeSummary> tradeSummary3);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel0);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel1, int _idx);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel2);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModel3);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addParty(Party party0);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addParty(Party party1, int _idx);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addParty(List<? extends Party> party2);
		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("task"), processor, LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder.class, getTask());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeSettlementTaskNotification  ***********************/
	class LoanTradeSettlementTaskNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanTradeSettlementTaskNotification {
		private final List<? extends LoanTradeSettlementTask> task;
		private final List<? extends LoanTradeSummary> tradeSummary;
		private final List<? extends FacilityDetailsModel> facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTradeSettlementTaskNotificationImpl(LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder builder) {
			super(builder);
			this.task = ofNullable(builder.getTask()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("task")
		public List<? extends LoanTradeSettlementTask> getTask() {
			return task;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public List<? extends LoanTradeSummary> getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public List<? extends FacilityDetailsModel> getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification build() {
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder toBuilder() {
			LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTask()).ifPresent(builder::setTask);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSettlementTaskNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(task, _that.getTask())) return false;
			if (!ListEquals.listEquals(tradeSummary, _that.getTradeSummary())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (task != null ? task.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTaskNotification {" +
				"task=" + this.task + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeSettlementTaskNotification  ***********************/
	class LoanTradeSettlementTaskNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder {
	
		protected List<LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder> task = new ArrayList<>();
		protected List<LoanTradeSummary.LoanTradeSummaryBuilder> tradeSummary = new ArrayList<>();
		protected List<FacilityDetailsModel.FacilityDetailsModelBuilder> facilityDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTradeSettlementTaskNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("task")
		public List<? extends LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder> getTask() {
			return task;
		}
		
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder getOrCreateTask(int _index) {
		
			if (task==null) {
				this.task = new ArrayList<>();
			}
			LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder result;
			return getIndex(task, _index, () -> {
						LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder newTask = LoanTradeSettlementTask.builder();
						return newTask;
					});
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public List<? extends LoanTradeSummary.LoanTradeSummaryBuilder> getTradeSummary() {
			return tradeSummary;
		}
		
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary(int _index) {
		
			if (tradeSummary==null) {
				this.tradeSummary = new ArrayList<>();
			}
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			return getIndex(tradeSummary, _index, () -> {
						LoanTradeSummary.LoanTradeSummaryBuilder newTradeSummary = LoanTradeSummary.builder();
						return newTradeSummary;
					});
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public List<? extends FacilityDetailsModel.FacilityDetailsModelBuilder> getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel(int _index) {
		
			if (facilityDetailsModel==null) {
				this.facilityDetailsModel = new ArrayList<>();
			}
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			return getIndex(facilityDetailsModel, _index, () -> {
						FacilityDetailsModel.FacilityDetailsModelBuilder newFacilityDetailsModel = FacilityDetailsModel.builder();
						return newFacilityDetailsModel;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTask(LoanTradeSettlementTask task) {
			if (task!=null) this.task.add(task.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTask(LoanTradeSettlementTask task, int _idx) {
			getIndex(this.task, _idx, () -> task.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTask(List<? extends LoanTradeSettlementTask> tasks) {
			if (tasks != null) {
				for (LoanTradeSettlementTask toAdd : tasks) {
					this.task.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("task")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setTask(List<? extends LoanTradeSettlementTask> tasks) {
			if (tasks == null)  {
				this.task = new ArrayList<>();
			}
			else {
				this.task = tasks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary) {
			if (tradeSummary!=null) this.tradeSummary.add(tradeSummary.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTradeSummary(LoanTradeSummary tradeSummary, int _idx) {
			getIndex(this.tradeSummary, _idx, () -> tradeSummary.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addTradeSummary(List<? extends LoanTradeSummary> tradeSummarys) {
			if (tradeSummarys != null) {
				for (LoanTradeSummary toAdd : tradeSummarys) {
					this.tradeSummary.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeSummary")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setTradeSummary(List<? extends LoanTradeSummary> tradeSummarys) {
			if (tradeSummarys == null)  {
				this.tradeSummary = new ArrayList<>();
			}
			else {
				this.tradeSummary = tradeSummarys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			if (facilityDetailsModel!=null) this.facilityDetailsModel.add(facilityDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel, int _idx) {
			getIndex(this.facilityDetailsModel, _idx, () -> facilityDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels != null) {
				for (FacilityDetailsModel toAdd : facilityDetailsModels) {
					this.facilityDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityDetailsModel")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setFacilityDetailsModel(List<? extends FacilityDetailsModel> facilityDetailsModels) {
			if (facilityDetailsModels == null)  {
				this.facilityDetailsModel = new ArrayList<>();
			}
			else {
				this.facilityDetailsModel = facilityDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanTradeSettlementTaskNotification build() {
			return new LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationImpl(this);
		}
		
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder prune() {
			super.prune();
			task = task.stream().filter(b->b!=null).<LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeSummary = tradeSummary.stream().filter(b->b!=null).<LoanTradeSummary.LoanTradeSummaryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityDetailsModel = facilityDetailsModel.stream().filter(b->b!=null).<FacilityDetailsModel.FacilityDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTask()!=null && getTask().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder o = (LoanTradeSettlementTaskNotification.LoanTradeSettlementTaskNotificationBuilder) other;
			
			merger.mergeRosetta(getTask(), o.getTask(), this::getOrCreateTask);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::getOrCreateTradeSummary);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::getOrCreateFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSettlementTaskNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(task, _that.getTask())) return false;
			if (!ListEquals.listEquals(tradeSummary, _that.getTradeSummary())) return false;
			if (!ListEquals.listEquals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (task != null ? task.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTaskNotificationBuilder {" +
				"task=" + this.task + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
