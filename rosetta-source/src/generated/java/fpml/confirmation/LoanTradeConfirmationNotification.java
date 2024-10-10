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
import fpml.confirmation.LoanTradeConfirmationNotification;
import fpml.confirmation.LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder;
import fpml.confirmation.LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilderImpl;
import fpml.confirmation.LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationImpl;
import fpml.confirmation.LoanTradeEvent;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanTradeConfirmationNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate confirmation of master trade details, from counterparty to counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeConfirmationNotification", builder=LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilderImpl.class, version="${project.version}")
public interface LoanTradeConfirmationNotification extends AbstractLoanTradingNotification {

	LoanTradeConfirmationNotificationMeta metaData = new LoanTradeConfirmationNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to confirm the original loan trade event, conveyed in the Loan Trade Notification.
	 */
	LoanTradeEvent getConfirmation();
	/**
	 * A summary of the trade.
	 */
	LoanTradeSummary getTradeSummary();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTradeConfirmationNotification build();
	
	LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder toBuilder();
	
	static LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder builder() {
		return new LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeConfirmationNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeConfirmationNotification> getType() {
		return LoanTradeConfirmationNotification.class;
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
		processRosetta(path.newSubPath("confirmation"), processor, LoanTradeEvent.class, getConfirmation());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeConfirmationNotificationBuilder extends LoanTradeConfirmationNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTradeEvent.LoanTradeEventBuilder getOrCreateConfirmation();
		LoanTradeEvent.LoanTradeEventBuilder getConfirmation();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setActualBuild(Integer actualBuild);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setHeader(RequestMessageHeader header);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setNoticeDate(Date noticeDate);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setConfirmation(LoanTradeEvent confirmation);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder addParty(Party party0);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder addParty(Party party1, int _idx);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder addParty(List<? extends Party> party2);
		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("confirmation"), processor, LoanTradeEvent.LoanTradeEventBuilder.class, getConfirmation());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeConfirmationNotification  ***********************/
	class LoanTradeConfirmationNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanTradeConfirmationNotification {
		private final LoanTradeEvent confirmation;
		private final LoanTradeSummary tradeSummary;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanTradeConfirmationNotificationImpl(LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder builder) {
			super(builder);
			this.confirmation = ofNullable(builder.getConfirmation()).map(f->f.build()).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("confirmation")
		public LoanTradeEvent getConfirmation() {
			return confirmation;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanTradeConfirmationNotification build() {
			return this;
		}
		
		@Override
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder toBuilder() {
			LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConfirmation()).ifPresent(builder::setConfirmation);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeConfirmationNotification _that = getType().cast(o);
		
			if (!Objects.equals(confirmation, _that.getConfirmation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (confirmation != null ? confirmation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeConfirmationNotification {" +
				"confirmation=" + this.confirmation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeConfirmationNotification  ***********************/
	class LoanTradeConfirmationNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder {
	
		protected LoanTradeEvent.LoanTradeEventBuilder confirmation;
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanTradeConfirmationNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("confirmation")
		public LoanTradeEvent.LoanTradeEventBuilder getConfirmation() {
			return confirmation;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder getOrCreateConfirmation() {
			LoanTradeEvent.LoanTradeEventBuilder result;
			if (confirmation!=null) {
				result = confirmation;
			}
			else {
				result = confirmation = LoanTradeEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary() {
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = LoanTradeSummary.builder();
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
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("confirmation")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setConfirmation(LoanTradeEvent confirmation) {
			this.confirmation = confirmation==null?null:confirmation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanTradeConfirmationNotification build() {
			return new LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationImpl(this);
		}
		
		@Override
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder prune() {
			super.prune();
			if (confirmation!=null && !confirmation.prune().hasData()) confirmation = null;
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConfirmation()!=null && getConfirmation().hasData()) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder o = (LoanTradeConfirmationNotification.LoanTradeConfirmationNotificationBuilder) other;
			
			merger.mergeRosetta(getConfirmation(), o.getConfirmation(), this::setConfirmation);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeConfirmationNotification _that = getType().cast(o);
		
			if (!Objects.equals(confirmation, _that.getConfirmation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (confirmation != null ? confirmation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeConfirmationNotificationBuilder {" +
				"confirmation=" + this.confirmation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
