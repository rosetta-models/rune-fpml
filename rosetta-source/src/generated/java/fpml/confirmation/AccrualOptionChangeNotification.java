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
import fpml.confirmation.AbstractContractNotification;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationBuilder;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationBuilderImpl;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationImpl;
import fpml.confirmation.AccrualOptionChangeNotification;
import fpml.confirmation.AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder;
import fpml.confirmation.AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilderImpl;
import fpml.confirmation.AccrualOptionChangeNotification.AccrualOptionChangeNotificationImpl;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1;
import fpml.confirmation.AccruingPikOptionChange;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AccrualOptionChangeNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to update an accrual option within a single facility. Embedded business events simply re-state the given accrual option.
 * @version ${project.version}
 */
@RosettaDataType(value="AccrualOptionChangeNotification", builder=AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilderImpl.class, version="${project.version}")
public interface AccrualOptionChangeNotification extends AbstractContractNotification {

	AccrualOptionChangeNotificationMeta metaData = new AccrualOptionChangeNotificationMeta();

	/*********************** Getter Methods  ***********************/
	AccrualOptionChangeNotificationSequence0 getAccrualOptionChangeNotificationSequence0();
	AccruingPikOptionChange getAccruingPikOptionChange();
	AccrualOptionChangeNotificationSequence1 getAccrualOptionChangeNotificationSequence1();
	FacilityDetailsModel getFacilityDetailsModel();
	List<? extends LoanContractDetailsModel> getLoanContractDetailsModel();
	List<? extends LetterOfCreditDetailsModel> getLetterOfCreditDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	AccrualOptionChangeNotification build();
	
	AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder toBuilder();
	
	static AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder builder() {
		return new AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualOptionChangeNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccrualOptionChangeNotification> getType() {
		return AccrualOptionChangeNotification.class;
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
		processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.class, getFacilityOutstandingsPosition());
		processRosetta(path.newSubPath("accrualOptionChangeNotificationSequence0"), processor, AccrualOptionChangeNotificationSequence0.class, getAccrualOptionChangeNotificationSequence0());
		processRosetta(path.newSubPath("accruingPikOptionChange"), processor, AccruingPikOptionChange.class, getAccruingPikOptionChange());
		processRosetta(path.newSubPath("accrualOptionChangeNotificationSequence1"), processor, AccrualOptionChangeNotificationSequence1.class, getAccrualOptionChangeNotificationSequence1());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
		processRosetta(path.newSubPath("letterOfCreditDetailsModel"), processor, LetterOfCreditDetailsModel.class, getLetterOfCreditDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualOptionChangeNotificationBuilder extends AccrualOptionChangeNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder getOrCreateAccrualOptionChangeNotificationSequence0();
		AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder getAccrualOptionChangeNotificationSequence0();
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder getOrCreateAccruingPikOptionChange();
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder getAccruingPikOptionChange();
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder getOrCreateAccrualOptionChangeNotificationSequence1();
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder getAccrualOptionChangeNotificationSequence1();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index);
		List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel();
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getOrCreateLetterOfCreditDetailsModel(int _index);
		List<? extends LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder> getLetterOfCreditDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setActualBuild(Integer actualBuild);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setHeader(RequestMessageHeader header);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setValidationModel(ValidationModel validationModel);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setIsCorrection(Boolean isCorrection);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setNoticeDate(Date noticeDate);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setAccrualOptionChangeNotificationSequence0(AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setAccruingPikOptionChange(AccruingPikOptionChange accruingPikOptionChange);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setAccrualOptionChangeNotificationSequence1(AccrualOptionChangeNotificationSequence1 accrualOptionChangeNotificationSequence1);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel0);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel1, int _idx);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel2);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel3);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel0);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel1, int _idx);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLetterOfCreditDetailsModel(List<? extends LetterOfCreditDetailsModel> letterOfCreditDetailsModel2);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setLetterOfCreditDetailsModel(List<? extends LetterOfCreditDetailsModel> letterOfCreditDetailsModel3);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addParty(Party party0);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addParty(Party party1, int _idx);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addParty(List<? extends Party> party2);
		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder.class, getFacilityOutstandingsPosition());
			processRosetta(path.newSubPath("accrualOptionChangeNotificationSequence0"), processor, AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder.class, getAccrualOptionChangeNotificationSequence0());
			processRosetta(path.newSubPath("accruingPikOptionChange"), processor, AccruingPikOptionChange.AccruingPikOptionChangeBuilder.class, getAccruingPikOptionChange());
			processRosetta(path.newSubPath("accrualOptionChangeNotificationSequence1"), processor, AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder.class, getAccrualOptionChangeNotificationSequence1());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
			processRosetta(path.newSubPath("letterOfCreditDetailsModel"), processor, LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder.class, getLetterOfCreditDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualOptionChangeNotification  ***********************/
	class AccrualOptionChangeNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements AccrualOptionChangeNotification {
		private final AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0;
		private final AccruingPikOptionChange accruingPikOptionChange;
		private final AccrualOptionChangeNotificationSequence1 accrualOptionChangeNotificationSequence1;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends LoanContractDetailsModel> loanContractDetailsModel;
		private final List<? extends LetterOfCreditDetailsModel> letterOfCreditDetailsModel;
		private final List<? extends Party> party;
		
		protected AccrualOptionChangeNotificationImpl(AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder builder) {
			super(builder);
			this.accrualOptionChangeNotificationSequence0 = ofNullable(builder.getAccrualOptionChangeNotificationSequence0()).map(f->f.build()).orElse(null);
			this.accruingPikOptionChange = ofNullable(builder.getAccruingPikOptionChange()).map(f->f.build()).orElse(null);
			this.accrualOptionChangeNotificationSequence1 = ofNullable(builder.getAccrualOptionChangeNotificationSequence1()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.letterOfCreditDetailsModel = ofNullable(builder.getLetterOfCreditDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualOptionChangeNotificationSequence0")
		public AccrualOptionChangeNotificationSequence0 getAccrualOptionChangeNotificationSequence0() {
			return accrualOptionChangeNotificationSequence0;
		}
		
		@Override
		@RosettaAttribute("accruingPikOptionChange")
		public AccruingPikOptionChange getAccruingPikOptionChange() {
			return accruingPikOptionChange;
		}
		
		@Override
		@RosettaAttribute("accrualOptionChangeNotificationSequence1")
		public AccrualOptionChangeNotificationSequence1 getAccrualOptionChangeNotificationSequence1() {
			return accrualOptionChangeNotificationSequence1;
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
		@RosettaAttribute("letterOfCreditDetailsModel")
		public List<? extends LetterOfCreditDetailsModel> getLetterOfCreditDetailsModel() {
			return letterOfCreditDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public AccrualOptionChangeNotification build() {
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder toBuilder() {
			AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccrualOptionChangeNotificationSequence0()).ifPresent(builder::setAccrualOptionChangeNotificationSequence0);
			ofNullable(getAccruingPikOptionChange()).ifPresent(builder::setAccruingPikOptionChange);
			ofNullable(getAccrualOptionChangeNotificationSequence1()).ifPresent(builder::setAccrualOptionChangeNotificationSequence1);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
			ofNullable(getLetterOfCreditDetailsModel()).ifPresent(builder::setLetterOfCreditDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccrualOptionChangeNotification _that = getType().cast(o);
		
			if (!Objects.equals(accrualOptionChangeNotificationSequence0, _that.getAccrualOptionChangeNotificationSequence0())) return false;
			if (!Objects.equals(accruingPikOptionChange, _that.getAccruingPikOptionChange())) return false;
			if (!Objects.equals(accrualOptionChangeNotificationSequence1, _that.getAccrualOptionChangeNotificationSequence1())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(letterOfCreditDetailsModel, _that.getLetterOfCreditDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualOptionChangeNotificationSequence0 != null ? accrualOptionChangeNotificationSequence0.hashCode() : 0);
			_result = 31 * _result + (accruingPikOptionChange != null ? accruingPikOptionChange.hashCode() : 0);
			_result = 31 * _result + (accrualOptionChangeNotificationSequence1 != null ? accrualOptionChangeNotificationSequence1.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditDetailsModel != null ? letterOfCreditDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeNotification {" +
				"accrualOptionChangeNotificationSequence0=" + this.accrualOptionChangeNotificationSequence0 + ", " +
				"accruingPikOptionChange=" + this.accruingPikOptionChange + ", " +
				"accrualOptionChangeNotificationSequence1=" + this.accrualOptionChangeNotificationSequence1 + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"letterOfCreditDetailsModel=" + this.letterOfCreditDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccrualOptionChangeNotification  ***********************/
	class AccrualOptionChangeNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl  implements AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder {
	
		protected AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder accrualOptionChangeNotificationSequence0;
		protected AccruingPikOptionChange.AccruingPikOptionChangeBuilder accruingPikOptionChange;
		protected AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder accrualOptionChangeNotificationSequence1;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<LoanContractDetailsModel.LoanContractDetailsModelBuilder> loanContractDetailsModel = new ArrayList<>();
		protected List<LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder> letterOfCreditDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public AccrualOptionChangeNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accrualOptionChangeNotificationSequence0")
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder getAccrualOptionChangeNotificationSequence0() {
			return accrualOptionChangeNotificationSequence0;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder getOrCreateAccrualOptionChangeNotificationSequence0() {
			AccrualOptionChangeNotificationSequence0.AccrualOptionChangeNotificationSequence0Builder result;
			if (accrualOptionChangeNotificationSequence0!=null) {
				result = accrualOptionChangeNotificationSequence0;
			}
			else {
				result = accrualOptionChangeNotificationSequence0 = AccrualOptionChangeNotificationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruingPikOptionChange")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder getAccruingPikOptionChange() {
			return accruingPikOptionChange;
		}
		
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder getOrCreateAccruingPikOptionChange() {
			AccruingPikOptionChange.AccruingPikOptionChangeBuilder result;
			if (accruingPikOptionChange!=null) {
				result = accruingPikOptionChange;
			}
			else {
				result = accruingPikOptionChange = AccruingPikOptionChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualOptionChangeNotificationSequence1")
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder getAccrualOptionChangeNotificationSequence1() {
			return accrualOptionChangeNotificationSequence1;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder getOrCreateAccrualOptionChangeNotificationSequence1() {
			AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder result;
			if (accrualOptionChangeNotificationSequence1!=null) {
				result = accrualOptionChangeNotificationSequence1;
			}
			else {
				result = accrualOptionChangeNotificationSequence1 = AccrualOptionChangeNotificationSequence1.builder();
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
		@RosettaAttribute("letterOfCreditDetailsModel")
		public List<? extends LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder> getLetterOfCreditDetailsModel() {
			return letterOfCreditDetailsModel;
		}
		
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getOrCreateLetterOfCreditDetailsModel(int _index) {
		
			if (letterOfCreditDetailsModel==null) {
				this.letterOfCreditDetailsModel = new ArrayList<>();
			}
			LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder result;
			return getIndex(letterOfCreditDetailsModel, _index, () -> {
						LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder newLetterOfCreditDetailsModel = LetterOfCreditDetailsModel.builder();
						return newLetterOfCreditDetailsModel;
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
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions == null)  {
				this.facilityOutstandingsPosition = new ArrayList<>();
			}
			else {
				this.facilityOutstandingsPosition = facilityOutstandingsPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("accrualOptionChangeNotificationSequence0")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setAccrualOptionChangeNotificationSequence0(AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0) {
			this.accrualOptionChangeNotificationSequence0 = accrualOptionChangeNotificationSequence0==null?null:accrualOptionChangeNotificationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingPikOptionChange")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setAccruingPikOptionChange(AccruingPikOptionChange accruingPikOptionChange) {
			this.accruingPikOptionChange = accruingPikOptionChange==null?null:accruingPikOptionChange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrualOptionChangeNotificationSequence1")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setAccrualOptionChangeNotificationSequence1(AccrualOptionChangeNotificationSequence1 accrualOptionChangeNotificationSequence1) {
			this.accrualOptionChangeNotificationSequence1 = accrualOptionChangeNotificationSequence1==null?null:accrualOptionChangeNotificationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			if (loanContractDetailsModel!=null) this.loanContractDetailsModel.add(loanContractDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel, int _idx) {
			getIndex(this.loanContractDetailsModel, _idx, () -> loanContractDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels != null) {
				for (LoanContractDetailsModel toAdd : loanContractDetailsModels) {
					this.loanContractDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractDetailsModel")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
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
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel) {
			if (letterOfCreditDetailsModel!=null) this.letterOfCreditDetailsModel.add(letterOfCreditDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel, int _idx) {
			getIndex(this.letterOfCreditDetailsModel, _idx, () -> letterOfCreditDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addLetterOfCreditDetailsModel(List<? extends LetterOfCreditDetailsModel> letterOfCreditDetailsModels) {
			if (letterOfCreditDetailsModels != null) {
				for (LetterOfCreditDetailsModel toAdd : letterOfCreditDetailsModels) {
					this.letterOfCreditDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("letterOfCreditDetailsModel")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setLetterOfCreditDetailsModel(List<? extends LetterOfCreditDetailsModel> letterOfCreditDetailsModels) {
			if (letterOfCreditDetailsModels == null)  {
				this.letterOfCreditDetailsModel = new ArrayList<>();
			}
			else {
				this.letterOfCreditDetailsModel = letterOfCreditDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder setParty(List<? extends Party> partys) {
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
		public AccrualOptionChangeNotification build() {
			return new AccrualOptionChangeNotification.AccrualOptionChangeNotificationImpl(this);
		}
		
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder prune() {
			super.prune();
			if (accrualOptionChangeNotificationSequence0!=null && !accrualOptionChangeNotificationSequence0.prune().hasData()) accrualOptionChangeNotificationSequence0 = null;
			if (accruingPikOptionChange!=null && !accruingPikOptionChange.prune().hasData()) accruingPikOptionChange = null;
			if (accrualOptionChangeNotificationSequence1!=null && !accrualOptionChangeNotificationSequence1.prune().hasData()) accrualOptionChangeNotificationSequence1 = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			loanContractDetailsModel = loanContractDetailsModel.stream().filter(b->b!=null).<LoanContractDetailsModel.LoanContractDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			letterOfCreditDetailsModel = letterOfCreditDetailsModel.stream().filter(b->b!=null).<LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccrualOptionChangeNotificationSequence0()!=null && getAccrualOptionChangeNotificationSequence0().hasData()) return true;
			if (getAccruingPikOptionChange()!=null && getAccruingPikOptionChange().hasData()) return true;
			if (getAccrualOptionChangeNotificationSequence1()!=null && getAccrualOptionChangeNotificationSequence1().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLetterOfCreditDetailsModel()!=null && getLetterOfCreditDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder o = (AccrualOptionChangeNotification.AccrualOptionChangeNotificationBuilder) other;
			
			merger.mergeRosetta(getAccrualOptionChangeNotificationSequence0(), o.getAccrualOptionChangeNotificationSequence0(), this::setAccrualOptionChangeNotificationSequence0);
			merger.mergeRosetta(getAccruingPikOptionChange(), o.getAccruingPikOptionChange(), this::setAccruingPikOptionChange);
			merger.mergeRosetta(getAccrualOptionChangeNotificationSequence1(), o.getAccrualOptionChangeNotificationSequence1(), this::setAccrualOptionChangeNotificationSequence1);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLoanContractDetailsModel(), o.getLoanContractDetailsModel(), this::getOrCreateLoanContractDetailsModel);
			merger.mergeRosetta(getLetterOfCreditDetailsModel(), o.getLetterOfCreditDetailsModel(), this::getOrCreateLetterOfCreditDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccrualOptionChangeNotification _that = getType().cast(o);
		
			if (!Objects.equals(accrualOptionChangeNotificationSequence0, _that.getAccrualOptionChangeNotificationSequence0())) return false;
			if (!Objects.equals(accruingPikOptionChange, _that.getAccruingPikOptionChange())) return false;
			if (!Objects.equals(accrualOptionChangeNotificationSequence1, _that.getAccrualOptionChangeNotificationSequence1())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(letterOfCreditDetailsModel, _that.getLetterOfCreditDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualOptionChangeNotificationSequence0 != null ? accrualOptionChangeNotificationSequence0.hashCode() : 0);
			_result = 31 * _result + (accruingPikOptionChange != null ? accruingPikOptionChange.hashCode() : 0);
			_result = 31 * _result + (accrualOptionChangeNotificationSequence1 != null ? accrualOptionChangeNotificationSequence1.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditDetailsModel != null ? letterOfCreditDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeNotificationBuilder {" +
				"accrualOptionChangeNotificationSequence0=" + this.accrualOptionChangeNotificationSequence0 + ", " +
				"accruingPikOptionChange=" + this.accruingPikOptionChange + ", " +
				"accrualOptionChangeNotificationSequence1=" + this.accrualOptionChangeNotificationSequence1 + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"letterOfCreditDetailsModel=" + this.letterOfCreditDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
