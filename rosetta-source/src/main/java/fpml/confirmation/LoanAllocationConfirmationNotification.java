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
import fpml.confirmation.LoanAllocationConfirmationNotification;
import fpml.confirmation.LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder;
import fpml.confirmation.LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilderImpl;
import fpml.confirmation.LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationImpl;
import fpml.confirmation.LoanAllocationEvent;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAllocationConfirmationNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A loan servicing notification used to communicate confirmation of trade allocation details, from counterparty to counterparty, or admin agent to counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationConfirmationNotification", builder=LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilderImpl.class, version="${project.version}")
public interface LoanAllocationConfirmationNotification extends AbstractLoanTradingNotification {

	LoanAllocationConfirmationNotificationMeta metaData = new LoanAllocationConfirmationNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure to confirm the allocation of a loan trade.
	 */
	LoanAllocationEvent getConfirmation();
	/**
	 * Unique allocation id used to identify the allocation record.
	 */
	List<? extends LoanAllocationIdentifier> getAllocationIdentifier();
	LoanTradeSummary getTradeSummary();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationConfirmationNotification build();
	
	LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder toBuilder();
	
	static LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder builder() {
		return new LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationConfirmationNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationConfirmationNotification> getType() {
		return LoanAllocationConfirmationNotification.class;
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
		processRosetta(path.newSubPath("confirmation"), processor, LoanAllocationEvent.class, getConfirmation());
		processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.class, getAllocationIdentifier());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationConfirmationNotificationBuilder extends LoanAllocationConfirmationNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanAllocationEvent.LoanAllocationEventBuilder getOrCreateConfirmation();
		LoanAllocationEvent.LoanAllocationEventBuilder getConfirmation();
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationIdentifier(int _index);
		List<? extends LoanAllocationIdentifier.LoanAllocationIdentifierBuilder> getAllocationIdentifier();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setActualBuild(Integer actualBuild);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setHeader(RequestMessageHeader header);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setNoticeDate(Date noticeDate);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setPartyReference(PartyReference partyReference);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setRole(LoanTradingPartyRole role);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setConfirmation(LoanAllocationEvent confirmation);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier0);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier1, int _idx);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addAllocationIdentifier(List<? extends LoanAllocationIdentifier> allocationIdentifier2);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setAllocationIdentifier(List<? extends LoanAllocationIdentifier> allocationIdentifier3);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addParty(Party party0);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addParty(Party party1, int _idx);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addParty(List<? extends Party> party2);
		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("confirmation"), processor, LoanAllocationEvent.LoanAllocationEventBuilder.class, getConfirmation());
			processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder.class, getAllocationIdentifier());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationConfirmationNotification  ***********************/
	class LoanAllocationConfirmationNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements LoanAllocationConfirmationNotification {
		private final LoanAllocationEvent confirmation;
		private final List<? extends LoanAllocationIdentifier> allocationIdentifier;
		private final LoanTradeSummary tradeSummary;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected LoanAllocationConfirmationNotificationImpl(LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder builder) {
			super(builder);
			this.confirmation = ofNullable(builder.getConfirmation()).map(f->f.build()).orElse(null);
			this.allocationIdentifier = ofNullable(builder.getAllocationIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("confirmation")
		public LoanAllocationEvent getConfirmation() {
			return confirmation;
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public List<? extends LoanAllocationIdentifier> getAllocationIdentifier() {
			return allocationIdentifier;
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
		public LoanAllocationConfirmationNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder toBuilder() {
			LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConfirmation()).ifPresent(builder::setConfirmation);
			ofNullable(getAllocationIdentifier()).ifPresent(builder::setAllocationIdentifier);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationConfirmationNotification _that = getType().cast(o);
		
			if (!Objects.equals(confirmation, _that.getConfirmation())) return false;
			if (!ListEquals.listEquals(allocationIdentifier, _that.getAllocationIdentifier())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (confirmation != null ? confirmation.hashCode() : 0);
			_result = 31 * _result + (allocationIdentifier != null ? allocationIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationConfirmationNotification {" +
				"confirmation=" + this.confirmation + ", " +
				"allocationIdentifier=" + this.allocationIdentifier + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationConfirmationNotification  ***********************/
	class LoanAllocationConfirmationNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder {
	
		protected LoanAllocationEvent.LoanAllocationEventBuilder confirmation;
		protected List<LoanAllocationIdentifier.LoanAllocationIdentifierBuilder> allocationIdentifier = new ArrayList<>();
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanAllocationConfirmationNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("confirmation")
		public LoanAllocationEvent.LoanAllocationEventBuilder getConfirmation() {
			return confirmation;
		}
		
		@Override
		public LoanAllocationEvent.LoanAllocationEventBuilder getOrCreateConfirmation() {
			LoanAllocationEvent.LoanAllocationEventBuilder result;
			if (confirmation!=null) {
				result = confirmation;
			}
			else {
				result = confirmation = LoanAllocationEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public List<? extends LoanAllocationIdentifier.LoanAllocationIdentifierBuilder> getAllocationIdentifier() {
			return allocationIdentifier;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationIdentifier(int _index) {
		
			if (allocationIdentifier==null) {
				this.allocationIdentifier = new ArrayList<>();
			}
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder result;
			return getIndex(allocationIdentifier, _index, () -> {
						LoanAllocationIdentifier.LoanAllocationIdentifierBuilder newAllocationIdentifier = LoanAllocationIdentifier.builder();
						return newAllocationIdentifier;
					});
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
		
		@Override
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
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("confirmation")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setConfirmation(LoanAllocationEvent confirmation) {
			this.confirmation = confirmation==null?null:confirmation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocationIdentifier")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier) {
			if (allocationIdentifier!=null) this.allocationIdentifier.add(allocationIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier, int _idx) {
			getIndex(this.allocationIdentifier, _idx, () -> allocationIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addAllocationIdentifier(List<? extends LoanAllocationIdentifier> allocationIdentifiers) {
			if (allocationIdentifiers != null) {
				for (LoanAllocationIdentifier toAdd : allocationIdentifiers) {
					this.allocationIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setAllocationIdentifier(List<? extends LoanAllocationIdentifier> allocationIdentifiers) {
			if (allocationIdentifiers == null)  {
				this.allocationIdentifier = new ArrayList<>();
			}
			else {
				this.allocationIdentifier = allocationIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanAllocationConfirmationNotification build() {
			return new LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder prune() {
			super.prune();
			if (confirmation!=null && !confirmation.prune().hasData()) confirmation = null;
			allocationIdentifier = allocationIdentifier.stream().filter(b->b!=null).<LoanAllocationIdentifier.LoanAllocationIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConfirmation()!=null && getConfirmation().hasData()) return true;
			if (getAllocationIdentifier()!=null && getAllocationIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder o = (LoanAllocationConfirmationNotification.LoanAllocationConfirmationNotificationBuilder) other;
			
			merger.mergeRosetta(getConfirmation(), o.getConfirmation(), this::setConfirmation);
			merger.mergeRosetta(getAllocationIdentifier(), o.getAllocationIdentifier(), this::getOrCreateAllocationIdentifier);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationConfirmationNotification _that = getType().cast(o);
		
			if (!Objects.equals(confirmation, _that.getConfirmation())) return false;
			if (!ListEquals.listEquals(allocationIdentifier, _that.getAllocationIdentifier())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (confirmation != null ? confirmation.hashCode() : 0);
			_result = 31 * _result + (allocationIdentifier != null ? allocationIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationConfirmationNotificationBuilder {" +
				"confirmation=" + this.confirmation + ", " +
				"allocationIdentifier=" + this.allocationIdentifier + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
