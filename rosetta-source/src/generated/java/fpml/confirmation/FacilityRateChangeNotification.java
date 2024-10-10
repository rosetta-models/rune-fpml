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
import fpml.confirmation.AbstractFacilityContractEvent;
import fpml.confirmation.AbstractFacilityNotification;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilder;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.FacilityRateChangeNotification;
import fpml.confirmation.FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder;
import fpml.confirmation.FacilityRateChangeNotification.FacilityRateChangeNotificationBuilderImpl;
import fpml.confirmation.FacilityRateChangeNotification.FacilityRateChangeNotificationImpl;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.FacilityRateChangeNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate changes in facility-level rates (e.g. penalty rate, default rate etc.).
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityRateChangeNotification", builder=FacilityRateChangeNotification.FacilityRateChangeNotificationBuilderImpl.class, version="${project.version}")
public interface FacilityRateChangeNotification extends AbstractFacilityNotification {

	FacilityRateChangeNotificationMeta metaData = new FacilityRateChangeNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AbstractFacilityContractEvent getFacilityRateChangeGroup();
	FacilityDetailsModel getFacilityDetailsModel();
	List<? extends LoanContractDetailsModel> getLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	FacilityRateChangeNotification build();
	
	FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder toBuilder();
	
	static FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder builder() {
		return new FacilityRateChangeNotification.FacilityRateChangeNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityRateChangeNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityRateChangeNotification> getType() {
		return FacilityRateChangeNotification.class;
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
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
		processRosetta(path.newSubPath("facilityRateChangeGroup"), processor, AbstractFacilityContractEvent.class, getFacilityRateChangeGroup());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityRateChangeNotificationBuilder extends FacilityRateChangeNotification, AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder getOrCreateFacilityRateChangeGroup();
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder getFacilityRateChangeGroup();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index);
		List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setExpectedBuild(Integer expectedBuild);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setActualBuild(Integer actualBuild);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setHeader(RequestMessageHeader header);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setValidationModel(ValidationModel validationModel);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setIsCorrection(Boolean isCorrection);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setNoticeDate(Date noticeDate);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addEventPayment(EventPayment eventPayment0);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setFacilityRateChangeGroup(AbstractFacilityContractEvent facilityRateChangeGroup);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel0);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel1, int _idx);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel2);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel3);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addParty(Party party0);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addParty(Party party1, int _idx);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addParty(List<? extends Party> party2);
		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setParty(List<? extends Party> party3);

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
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
			processRosetta(path.newSubPath("facilityRateChangeGroup"), processor, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder.class, getFacilityRateChangeGroup());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityRateChangeNotification  ***********************/
	class FacilityRateChangeNotificationImpl extends AbstractFacilityNotification.AbstractFacilityNotificationImpl implements FacilityRateChangeNotification {
		private final AbstractFacilityContractEvent facilityRateChangeGroup;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends LoanContractDetailsModel> loanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected FacilityRateChangeNotificationImpl(FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder builder) {
			super(builder);
			this.facilityRateChangeGroup = ofNullable(builder.getFacilityRateChangeGroup()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityRateChangeGroup")
		public AbstractFacilityContractEvent getFacilityRateChangeGroup() {
			return facilityRateChangeGroup;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public List<? extends LoanContractDetailsModel> getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public FacilityRateChangeNotification build() {
			return this;
		}
		
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder toBuilder() {
			FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityRateChangeGroup()).ifPresent(builder::setFacilityRateChangeGroup);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityRateChangeNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityRateChangeGroup, _that.getFacilityRateChangeGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityRateChangeGroup != null ? facilityRateChangeGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRateChangeNotification {" +
				"facilityRateChangeGroup=" + this.facilityRateChangeGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityRateChangeNotification  ***********************/
	class FacilityRateChangeNotificationBuilderImpl extends AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl  implements FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder {
	
		protected AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder facilityRateChangeGroup;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<LoanContractDetailsModel.LoanContractDetailsModelBuilder> loanContractDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public FacilityRateChangeNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityRateChangeGroup")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder getFacilityRateChangeGroup() {
			return facilityRateChangeGroup;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder getOrCreateFacilityRateChangeGroup() {
			AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder result;
			if (facilityRateChangeGroup!=null) {
				result = facilityRateChangeGroup;
			}
			else {
				result = facilityRateChangeGroup = AbstractFacilityContractEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel() {
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			if (facilityDetailsModel!=null) {
				result = facilityDetailsModel;
			}
			else {
				result = facilityDetailsModel = FacilityDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index) {
		
			if (loanContractDetailsModel==null) {
				this.loanContractDetailsModel = new ArrayList<>();
			}
			LoanContractDetailsModel.LoanContractDetailsModelBuilder result;
			return getIndex(loanContractDetailsModel, _index, () -> {
						LoanContractDetailsModel.LoanContractDetailsModelBuilder newLoanContractDetailsModel = LoanContractDetailsModel.builder();
						return newLoanContractDetailsModel;
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
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null)  {
				this.eventPayment = new ArrayList<>();
			}
			else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityRateChangeGroup")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setFacilityRateChangeGroup(AbstractFacilityContractEvent facilityRateChangeGroup) {
			this.facilityRateChangeGroup = facilityRateChangeGroup==null?null:facilityRateChangeGroup.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			if (loanContractDetailsModel!=null) this.loanContractDetailsModel.add(loanContractDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel, int _idx) {
			getIndex(this.loanContractDetailsModel, _idx, () -> loanContractDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels != null) {
				for (LoanContractDetailsModel toAdd : loanContractDetailsModels) {
					this.loanContractDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractDetailsModel")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels == null)  {
				this.loanContractDetailsModel = new ArrayList<>();
			}
			else {
				this.loanContractDetailsModel = loanContractDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder setParty(List<? extends Party> partys) {
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
		public FacilityRateChangeNotification build() {
			return new FacilityRateChangeNotification.FacilityRateChangeNotificationImpl(this);
		}
		
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder prune() {
			super.prune();
			if (facilityRateChangeGroup!=null && !facilityRateChangeGroup.prune().hasData()) facilityRateChangeGroup = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			loanContractDetailsModel = loanContractDetailsModel.stream().filter(b->b!=null).<LoanContractDetailsModel.LoanContractDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityRateChangeGroup()!=null && getFacilityRateChangeGroup().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder o = (FacilityRateChangeNotification.FacilityRateChangeNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityRateChangeGroup(), o.getFacilityRateChangeGroup(), this::setFacilityRateChangeGroup);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLoanContractDetailsModel(), o.getLoanContractDetailsModel(), this::getOrCreateLoanContractDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityRateChangeNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityRateChangeGroup, _that.getFacilityRateChangeGroup())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityRateChangeGroup != null ? facilityRateChangeGroup.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRateChangeNotificationBuilder {" +
				"facilityRateChangeGroup=" + this.facilityRateChangeGroup + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
