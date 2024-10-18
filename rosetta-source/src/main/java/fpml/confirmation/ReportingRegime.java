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
import com.rosetta.util.ListEquals;
import fpml.confirmation.ActionType;
import fpml.confirmation.CurrencyPairClassification;
import fpml.confirmation.EntityClassification;
import fpml.confirmation.NotionalReportingType;
import fpml.confirmation.PartyEntityClassification;
import fpml.confirmation.PartyRelationshipType;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.ReportingBoolean;
import fpml.confirmation.ReportingPurpose;
import fpml.confirmation.ReportingRegime;
import fpml.confirmation.ReportingRegime.ReportingRegimeBuilder;
import fpml.confirmation.ReportingRegime.ReportingRegimeBuilderImpl;
import fpml.confirmation.ReportingRegime.ReportingRegimeImpl;
import fpml.confirmation.ReportingRegimeSequence0;
import fpml.confirmation.ReportingRegimeSequence1;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.meta.ReportingRegimeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides information about how the information in this message is applicable to a regulatory reporting process.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingRegime", builder=ReportingRegime.ReportingRegimeBuilderImpl.class, version="${project.version}")
public interface ReportingRegime extends RosettaModelObject {

	ReportingRegimeMeta metaData = new ReportingRegimeMeta();

	/*********************** Getter Methods  ***********************/
	ReportingRegimeSequence0 getReportingRegimeSequence0();
	/**
	 * Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();
	/**
	 * Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 */
	ReportingRole getReportingRole();
	/**
	 * The reason this message is being sent, for example Snapshot, PET, Confirmation, RealTimePublic.
	 */
	List<? extends ReportingPurpose> getReportingPurpose();
	/**
	 * Whether the particular trade type in question is required by this regulator to be cleared.
	 */
	ReportingBoolean getMandatorilyClearable();
	ReportingRegimeSequence1 getReportingRegimeSequence1();
	/**
	 * Indicates whether the counterparty exceeds the volume threshold above which trades are required to be cleared.
	 */
	Boolean getExceedsClearingThreshold();
	/**
	 * This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the &quot;partyReference&quot; in the partyTradeInformation block.
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 * Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 */
	EntityClassification getEntityClassification();
	/**
	 * Indicates the category or classification or business role of a trade party with respect to this reporting regime, for example Financial, NonFinancial, Dealer, Non-Dealer, LocalParty, etc.
	 */
	List<? extends PartyEntityClassification> getPartyEntityClassification();
	/**
	 * Indicates how the parties to the trade (the counterparties) are related to each other with respect to this reporting regime, e.g. Affiliated, Intragroup, etc..
	 */
	PartyRelationshipType getTradePartyRelationshipType();
	/**
	 * Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 */
	ActionType getActionType();
	/**
	 * Reports that this trade was executed prior to the enactment of the relevant reporting regulation.
	 */
	Boolean getPreEnactmentTrade();
	/**
	 * How the notional amount should be reported for the reporting regime. For example, for ESMA MiFIR it would be Nominal or MonetaryAmount.
	 */
	NotionalReportingType getNotionalType();
	/**
	 * Reports a regulator-specific code classifying the currency pair in the trade into risk categories such as Major Currencies or Emerging Markets.
	 */
	CurrencyPairClassification getCurrencyPairClassification();
	Boolean getTransmissionOfOrder();

	/*********************** Build Methods  ***********************/
	ReportingRegime build();
	
	ReportingRegime.ReportingRegimeBuilder toBuilder();
	
	static ReportingRegime.ReportingRegimeBuilder builder() {
		return new ReportingRegime.ReportingRegimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegime> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingRegime> getType() {
		return ReportingRegime.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportingRegimeSequence0"), processor, ReportingRegimeSequence0.class, getReportingRegimeSequence0());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("mandatorilyClearable"), processor, ReportingBoolean.class, getMandatorilyClearable());
		processRosetta(path.newSubPath("reportingRegimeSequence1"), processor, ReportingRegimeSequence1.class, getReportingRegimeSequence1());
		processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.class, getEntityClassification());
		processRosetta(path.newSubPath("partyEntityClassification"), processor, PartyEntityClassification.class, getPartyEntityClassification());
		processRosetta(path.newSubPath("tradePartyRelationshipType"), processor, PartyRelationshipType.class, getTradePartyRelationshipType());
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
		processor.processBasic(path.newSubPath("preEnactmentTrade"), Boolean.class, getPreEnactmentTrade(), this);
		processRosetta(path.newSubPath("notionalType"), processor, NotionalReportingType.class, getNotionalType());
		processRosetta(path.newSubPath("currencyPairClassification"), processor, CurrencyPairClassification.class, getCurrencyPairClassification());
		processor.processBasic(path.newSubPath("transmissionOfOrder"), Boolean.class, getTransmissionOfOrder(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeBuilder extends ReportingRegime, RosettaModelObjectBuilder {
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder getOrCreateReportingRegimeSequence0();
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder getReportingRegimeSequence0();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index);
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int _index);
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		ReportingBoolean.ReportingBooleanBuilder getOrCreateMandatorilyClearable();
		ReportingBoolean.ReportingBooleanBuilder getMandatorilyClearable();
		ReportingRegimeSequence1.ReportingRegimeSequence1Builder getOrCreateReportingRegimeSequence1();
		ReportingRegimeSequence1.ReportingRegimeSequence1Builder getReportingRegimeSequence1();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification();
		EntityClassification.EntityClassificationBuilder getEntityClassification();
		PartyEntityClassification.PartyEntityClassificationBuilder getOrCreatePartyEntityClassification(int _index);
		List<? extends PartyEntityClassification.PartyEntityClassificationBuilder> getPartyEntityClassification();
		PartyRelationshipType.PartyRelationshipTypeBuilder getOrCreateTradePartyRelationshipType();
		PartyRelationshipType.PartyRelationshipTypeBuilder getTradePartyRelationshipType();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		ActionType.ActionTypeBuilder getActionType();
		NotionalReportingType.NotionalReportingTypeBuilder getOrCreateNotionalType();
		NotionalReportingType.NotionalReportingTypeBuilder getNotionalType();
		CurrencyPairClassification.CurrencyPairClassificationBuilder getOrCreateCurrencyPairClassification();
		CurrencyPairClassification.CurrencyPairClassificationBuilder getCurrencyPairClassification();
		ReportingRegime.ReportingRegimeBuilder setReportingRegimeSequence0(ReportingRegimeSequence0 reportingRegimeSequence0);
		ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration0);
		ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration1, int _idx);
		ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration2);
		ReportingRegime.ReportingRegimeBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration3);
		ReportingRegime.ReportingRegimeBuilder setReportingRole(ReportingRole reportingRole);
		ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose reportingPurpose0);
		ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose reportingPurpose1, int _idx);
		ReportingRegime.ReportingRegimeBuilder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose2);
		ReportingRegime.ReportingRegimeBuilder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose3);
		ReportingRegime.ReportingRegimeBuilder setMandatorilyClearable(ReportingBoolean mandatorilyClearable);
		ReportingRegime.ReportingRegimeBuilder setReportingRegimeSequence1(ReportingRegimeSequence1 reportingRegimeSequence1);
		ReportingRegime.ReportingRegimeBuilder setExceedsClearingThreshold(Boolean exceedsClearingThreshold);
		ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty relatedParty0);
		ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		ReportingRegime.ReportingRegimeBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		ReportingRegime.ReportingRegimeBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);
		ReportingRegime.ReportingRegimeBuilder setEntityClassification(EntityClassification entityClassification);
		ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification partyEntityClassification0);
		ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification partyEntityClassification1, int _idx);
		ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassification2);
		ReportingRegime.ReportingRegimeBuilder setPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassification3);
		ReportingRegime.ReportingRegimeBuilder setTradePartyRelationshipType(PartyRelationshipType tradePartyRelationshipType);
		ReportingRegime.ReportingRegimeBuilder setActionType(ActionType actionType);
		ReportingRegime.ReportingRegimeBuilder setPreEnactmentTrade(Boolean preEnactmentTrade);
		ReportingRegime.ReportingRegimeBuilder setNotionalType(NotionalReportingType notionalType);
		ReportingRegime.ReportingRegimeBuilder setCurrencyPairClassification(CurrencyPairClassification currencyPairClassification);
		ReportingRegime.ReportingRegimeBuilder setTransmissionOfOrder(Boolean transmissionOfOrder);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportingRegimeSequence0"), processor, ReportingRegimeSequence0.ReportingRegimeSequence0Builder.class, getReportingRegimeSequence0());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("mandatorilyClearable"), processor, ReportingBoolean.ReportingBooleanBuilder.class, getMandatorilyClearable());
			processRosetta(path.newSubPath("reportingRegimeSequence1"), processor, ReportingRegimeSequence1.ReportingRegimeSequence1Builder.class, getReportingRegimeSequence1());
			processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.EntityClassificationBuilder.class, getEntityClassification());
			processRosetta(path.newSubPath("partyEntityClassification"), processor, PartyEntityClassification.PartyEntityClassificationBuilder.class, getPartyEntityClassification());
			processRosetta(path.newSubPath("tradePartyRelationshipType"), processor, PartyRelationshipType.PartyRelationshipTypeBuilder.class, getTradePartyRelationshipType());
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
			processor.processBasic(path.newSubPath("preEnactmentTrade"), Boolean.class, getPreEnactmentTrade(), this);
			processRosetta(path.newSubPath("notionalType"), processor, NotionalReportingType.NotionalReportingTypeBuilder.class, getNotionalType());
			processRosetta(path.newSubPath("currencyPairClassification"), processor, CurrencyPairClassification.CurrencyPairClassificationBuilder.class, getCurrencyPairClassification());
			processor.processBasic(path.newSubPath("transmissionOfOrder"), Boolean.class, getTransmissionOfOrder(), this);
		}
		

		ReportingRegime.ReportingRegimeBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingRegime  ***********************/
	class ReportingRegimeImpl implements ReportingRegime {
		private final ReportingRegimeSequence0 reportingRegimeSequence0;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final ReportingBoolean mandatorilyClearable;
		private final ReportingRegimeSequence1 reportingRegimeSequence1;
		private final Boolean exceedsClearingThreshold;
		private final List<? extends RelatedParty> relatedParty;
		private final EntityClassification entityClassification;
		private final List<? extends PartyEntityClassification> partyEntityClassification;
		private final PartyRelationshipType tradePartyRelationshipType;
		private final ActionType actionType;
		private final Boolean preEnactmentTrade;
		private final NotionalReportingType notionalType;
		private final CurrencyPairClassification currencyPairClassification;
		private final Boolean transmissionOfOrder;
		
		protected ReportingRegimeImpl(ReportingRegime.ReportingRegimeBuilder builder) {
			this.reportingRegimeSequence0 = ofNullable(builder.getReportingRegimeSequence0()).map(f->f.build()).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.mandatorilyClearable = ofNullable(builder.getMandatorilyClearable()).map(f->f.build()).orElse(null);
			this.reportingRegimeSequence1 = ofNullable(builder.getReportingRegimeSequence1()).map(f->f.build()).orElse(null);
			this.exceedsClearingThreshold = builder.getExceedsClearingThreshold();
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.entityClassification = ofNullable(builder.getEntityClassification()).map(f->f.build()).orElse(null);
			this.partyEntityClassification = ofNullable(builder.getPartyEntityClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradePartyRelationshipType = ofNullable(builder.getTradePartyRelationshipType()).map(f->f.build()).orElse(null);
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
			this.preEnactmentTrade = builder.getPreEnactmentTrade();
			this.notionalType = ofNullable(builder.getNotionalType()).map(f->f.build()).orElse(null);
			this.currencyPairClassification = ofNullable(builder.getCurrencyPairClassification()).map(f->f.build()).orElse(null);
			this.transmissionOfOrder = builder.getTransmissionOfOrder();
		}
		
		@Override
		@RosettaAttribute("reportingRegimeSequence0")
		public ReportingRegimeSequence0 getReportingRegimeSequence0() {
			return reportingRegimeSequence0;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		public List<? extends ReportingPurpose> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		public ReportingBoolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("reportingRegimeSequence1")
		public ReportingRegimeSequence1 getReportingRegimeSequence1() {
			return reportingRegimeSequence1;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		public EntityClassification getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		@RosettaAttribute("partyEntityClassification")
		public List<? extends PartyEntityClassification> getPartyEntityClassification() {
			return partyEntityClassification;
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		public PartyRelationshipType getTradePartyRelationshipType() {
			return tradePartyRelationshipType;
		}
		
		@Override
		@RosettaAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("preEnactmentTrade")
		public Boolean getPreEnactmentTrade() {
			return preEnactmentTrade;
		}
		
		@Override
		@RosettaAttribute("notionalType")
		public NotionalReportingType getNotionalType() {
			return notionalType;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassification")
		public CurrencyPairClassification getCurrencyPairClassification() {
			return currencyPairClassification;
		}
		
		@Override
		@RosettaAttribute("transmissionOfOrder")
		public Boolean getTransmissionOfOrder() {
			return transmissionOfOrder;
		}
		
		@Override
		public ReportingRegime build() {
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder toBuilder() {
			ReportingRegime.ReportingRegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegime.ReportingRegimeBuilder builder) {
			ofNullable(getReportingRegimeSequence0()).ifPresent(builder::setReportingRegimeSequence0);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getReportingRegimeSequence1()).ifPresent(builder::setReportingRegimeSequence1);
			ofNullable(getExceedsClearingThreshold()).ifPresent(builder::setExceedsClearingThreshold);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getEntityClassification()).ifPresent(builder::setEntityClassification);
			ofNullable(getPartyEntityClassification()).ifPresent(builder::setPartyEntityClassification);
			ofNullable(getTradePartyRelationshipType()).ifPresent(builder::setTradePartyRelationshipType);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getPreEnactmentTrade()).ifPresent(builder::setPreEnactmentTrade);
			ofNullable(getNotionalType()).ifPresent(builder::setNotionalType);
			ofNullable(getCurrencyPairClassification()).ifPresent(builder::setCurrencyPairClassification);
			ofNullable(getTransmissionOfOrder()).ifPresent(builder::setTransmissionOfOrder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegime _that = getType().cast(o);
		
			if (!Objects.equals(reportingRegimeSequence0, _that.getReportingRegimeSequence0())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(reportingRegimeSequence1, _that.getReportingRegimeSequence1())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			if (!ListEquals.listEquals(partyEntityClassification, _that.getPartyEntityClassification())) return false;
			if (!Objects.equals(tradePartyRelationshipType, _that.getTradePartyRelationshipType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(preEnactmentTrade, _that.getPreEnactmentTrade())) return false;
			if (!Objects.equals(notionalType, _that.getNotionalType())) return false;
			if (!Objects.equals(currencyPairClassification, _that.getCurrencyPairClassification())) return false;
			if (!Objects.equals(transmissionOfOrder, _that.getTransmissionOfOrder())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingRegimeSequence0 != null ? reportingRegimeSequence0.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (reportingRegimeSequence1 != null ? reportingRegimeSequence1.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			_result = 31 * _result + (partyEntityClassification != null ? partyEntityClassification.hashCode() : 0);
			_result = 31 * _result + (tradePartyRelationshipType != null ? tradePartyRelationshipType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (preEnactmentTrade != null ? preEnactmentTrade.hashCode() : 0);
			_result = 31 * _result + (notionalType != null ? notionalType.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassification != null ? currencyPairClassification.hashCode() : 0);
			_result = 31 * _result + (transmissionOfOrder != null ? transmissionOfOrder.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegime {" +
				"reportingRegimeSequence0=" + this.reportingRegimeSequence0 + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"reportingRegimeSequence1=" + this.reportingRegimeSequence1 + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"entityClassification=" + this.entityClassification + ", " +
				"partyEntityClassification=" + this.partyEntityClassification + ", " +
				"tradePartyRelationshipType=" + this.tradePartyRelationshipType + ", " +
				"actionType=" + this.actionType + ", " +
				"preEnactmentTrade=" + this.preEnactmentTrade + ", " +
				"notionalType=" + this.notionalType + ", " +
				"currencyPairClassification=" + this.currencyPairClassification + ", " +
				"transmissionOfOrder=" + this.transmissionOfOrder +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegime  ***********************/
	class ReportingRegimeBuilderImpl implements ReportingRegime.ReportingRegimeBuilder {
	
		protected ReportingRegimeSequence0.ReportingRegimeSequence0Builder reportingRegimeSequence0;
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected ReportingBoolean.ReportingBooleanBuilder mandatorilyClearable;
		protected ReportingRegimeSequence1.ReportingRegimeSequence1Builder reportingRegimeSequence1;
		protected Boolean exceedsClearingThreshold;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected EntityClassification.EntityClassificationBuilder entityClassification;
		protected List<PartyEntityClassification.PartyEntityClassificationBuilder> partyEntityClassification = new ArrayList<>();
		protected PartyRelationshipType.PartyRelationshipTypeBuilder tradePartyRelationshipType;
		protected ActionType.ActionTypeBuilder actionType;
		protected Boolean preEnactmentTrade;
		protected NotionalReportingType.NotionalReportingTypeBuilder notionalType;
		protected CurrencyPairClassification.CurrencyPairClassificationBuilder currencyPairClassification;
		protected Boolean transmissionOfOrder;
	
		public ReportingRegimeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reportingRegimeSequence0")
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder getReportingRegimeSequence0() {
			return reportingRegimeSequence0;
		}
		
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder getOrCreateReportingRegimeSequence0() {
			ReportingRegimeSequence0.ReportingRegimeSequence0Builder result;
			if (reportingRegimeSequence0!=null) {
				result = reportingRegimeSequence0;
			}
			else {
				result = reportingRegimeSequence0 = ReportingRegimeSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index) {
		
			if (supervisorRegistration==null) {
				this.supervisorRegistration = new ArrayList<>();
			}
			SupervisorRegistration.SupervisorRegistrationBuilder result;
			return getIndex(supervisorRegistration, _index, () -> {
						SupervisorRegistration.SupervisorRegistrationBuilder newSupervisorRegistration = SupervisorRegistration.builder();
						return newSupervisorRegistration;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public ReportingRole.ReportingRoleBuilder getReportingRole() {
			return reportingRole;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder getOrCreateReportingRole() {
			ReportingRole.ReportingRoleBuilder result;
			if (reportingRole!=null) {
				result = reportingRole;
			}
			else {
				result = reportingRole = ReportingRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		public List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		public ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int _index) {
		
			if (reportingPurpose==null) {
				this.reportingPurpose = new ArrayList<>();
			}
			ReportingPurpose.ReportingPurposeBuilder result;
			return getIndex(reportingPurpose, _index, () -> {
						ReportingPurpose.ReportingPurposeBuilder newReportingPurpose = ReportingPurpose.builder();
						return newReportingPurpose;
					});
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		public ReportingBoolean.ReportingBooleanBuilder getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		public ReportingBoolean.ReportingBooleanBuilder getOrCreateMandatorilyClearable() {
			ReportingBoolean.ReportingBooleanBuilder result;
			if (mandatorilyClearable!=null) {
				result = mandatorilyClearable;
			}
			else {
				result = mandatorilyClearable = ReportingBoolean.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingRegimeSequence1")
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder getReportingRegimeSequence1() {
			return reportingRegimeSequence1;
		}
		
		@Override
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder getOrCreateReportingRegimeSequence1() {
			ReportingRegimeSequence1.ReportingRegimeSequence1Builder result;
			if (reportingRegimeSequence1!=null) {
				result = reportingRegimeSequence1;
			}
			else {
				result = reportingRegimeSequence1 = ReportingRegimeSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		public EntityClassification.EntityClassificationBuilder getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification() {
			EntityClassification.EntityClassificationBuilder result;
			if (entityClassification!=null) {
				result = entityClassification;
			}
			else {
				result = entityClassification = EntityClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyEntityClassification")
		public List<? extends PartyEntityClassification.PartyEntityClassificationBuilder> getPartyEntityClassification() {
			return partyEntityClassification;
		}
		
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder getOrCreatePartyEntityClassification(int _index) {
		
			if (partyEntityClassification==null) {
				this.partyEntityClassification = new ArrayList<>();
			}
			PartyEntityClassification.PartyEntityClassificationBuilder result;
			return getIndex(partyEntityClassification, _index, () -> {
						PartyEntityClassification.PartyEntityClassificationBuilder newPartyEntityClassification = PartyEntityClassification.builder();
						return newPartyEntityClassification;
					});
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		public PartyRelationshipType.PartyRelationshipTypeBuilder getTradePartyRelationshipType() {
			return tradePartyRelationshipType;
		}
		
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder getOrCreateTradePartyRelationshipType() {
			PartyRelationshipType.PartyRelationshipTypeBuilder result;
			if (tradePartyRelationshipType!=null) {
				result = tradePartyRelationshipType;
			}
			else {
				result = tradePartyRelationshipType = PartyRelationshipType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("actionType")
		public ActionType.ActionTypeBuilder getActionType() {
			return actionType;
		}
		
		@Override
		public ActionType.ActionTypeBuilder getOrCreateActionType() {
			ActionType.ActionTypeBuilder result;
			if (actionType!=null) {
				result = actionType;
			}
			else {
				result = actionType = ActionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("preEnactmentTrade")
		public Boolean getPreEnactmentTrade() {
			return preEnactmentTrade;
		}
		
		@Override
		@RosettaAttribute("notionalType")
		public NotionalReportingType.NotionalReportingTypeBuilder getNotionalType() {
			return notionalType;
		}
		
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder getOrCreateNotionalType() {
			NotionalReportingType.NotionalReportingTypeBuilder result;
			if (notionalType!=null) {
				result = notionalType;
			}
			else {
				result = notionalType = NotionalReportingType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassification")
		public CurrencyPairClassification.CurrencyPairClassificationBuilder getCurrencyPairClassification() {
			return currencyPairClassification;
		}
		
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder getOrCreateCurrencyPairClassification() {
			CurrencyPairClassification.CurrencyPairClassificationBuilder result;
			if (currencyPairClassification!=null) {
				result = currencyPairClassification;
			}
			else {
				result = currencyPairClassification = CurrencyPairClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transmissionOfOrder")
		public Boolean getTransmissionOfOrder() {
			return transmissionOfOrder;
		}
		
		@Override
		@RosettaAttribute("reportingRegimeSequence0")
		public ReportingRegime.ReportingRegimeBuilder setReportingRegimeSequence0(ReportingRegimeSequence0 reportingRegimeSequence0) {
			this.reportingRegimeSequence0 = reportingRegimeSequence0==null?null:reportingRegimeSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("supervisorRegistration")
		public ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration) {
			if (supervisorRegistration!=null) this.supervisorRegistration.add(supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int _idx) {
			getIndex(this.supervisorRegistration, _idx, () -> supervisorRegistration.toBuilder());
			return this;
		}
		@Override 
		public ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReportingRegime.ReportingRegimeBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations == null)  {
				this.supervisorRegistration = new ArrayList<>();
			}
			else {
				this.supervisorRegistration = supervisorRegistrations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public ReportingRegime.ReportingRegimeBuilder setReportingRole(ReportingRole reportingRole) {
			this.reportingRole = reportingRole==null?null:reportingRole.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("reportingPurpose")
		public ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose reportingPurpose) {
			if (reportingPurpose!=null) this.reportingPurpose.add(reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose reportingPurpose, int _idx) {
			getIndex(this.reportingPurpose, _idx, () -> reportingPurpose.toBuilder());
			return this;
		}
		@Override 
		public ReportingRegime.ReportingRegimeBuilder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes != null) {
				for (ReportingPurpose toAdd : reportingPurposes) {
					this.reportingPurpose.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReportingRegime.ReportingRegimeBuilder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null)  {
				this.reportingPurpose = new ArrayList<>();
			}
			else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		public ReportingRegime.ReportingRegimeBuilder setMandatorilyClearable(ReportingBoolean mandatorilyClearable) {
			this.mandatorilyClearable = mandatorilyClearable==null?null:mandatorilyClearable.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("reportingRegimeSequence1")
		public ReportingRegime.ReportingRegimeBuilder setReportingRegimeSequence1(ReportingRegimeSequence1 reportingRegimeSequence1) {
			this.reportingRegimeSequence1 = reportingRegimeSequence1==null?null:reportingRegimeSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		public ReportingRegime.ReportingRegimeBuilder setExceedsClearingThreshold(Boolean exceedsClearingThreshold) {
			this.exceedsClearingThreshold = exceedsClearingThreshold==null?null:exceedsClearingThreshold;
			return this;
		}
		@Override
		@RosettaAttribute("relatedParty")
		public ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public ReportingRegime.ReportingRegimeBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReportingRegime.ReportingRegimeBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		public ReportingRegime.ReportingRegimeBuilder setEntityClassification(EntityClassification entityClassification) {
			this.entityClassification = entityClassification==null?null:entityClassification.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partyEntityClassification")
		public ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification partyEntityClassification) {
			if (partyEntityClassification!=null) this.partyEntityClassification.add(partyEntityClassification.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification partyEntityClassification, int _idx) {
			getIndex(this.partyEntityClassification, _idx, () -> partyEntityClassification.toBuilder());
			return this;
		}
		@Override 
		public ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassifications) {
			if (partyEntityClassifications != null) {
				for (PartyEntityClassification toAdd : partyEntityClassifications) {
					this.partyEntityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReportingRegime.ReportingRegimeBuilder setPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassifications) {
			if (partyEntityClassifications == null)  {
				this.partyEntityClassification = new ArrayList<>();
			}
			else {
				this.partyEntityClassification = partyEntityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		public ReportingRegime.ReportingRegimeBuilder setTradePartyRelationshipType(PartyRelationshipType tradePartyRelationshipType) {
			this.tradePartyRelationshipType = tradePartyRelationshipType==null?null:tradePartyRelationshipType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("actionType")
		public ReportingRegime.ReportingRegimeBuilder setActionType(ActionType actionType) {
			this.actionType = actionType==null?null:actionType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("preEnactmentTrade")
		public ReportingRegime.ReportingRegimeBuilder setPreEnactmentTrade(Boolean preEnactmentTrade) {
			this.preEnactmentTrade = preEnactmentTrade==null?null:preEnactmentTrade;
			return this;
		}
		@Override
		@RosettaAttribute("notionalType")
		public ReportingRegime.ReportingRegimeBuilder setNotionalType(NotionalReportingType notionalType) {
			this.notionalType = notionalType==null?null:notionalType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currencyPairClassification")
		public ReportingRegime.ReportingRegimeBuilder setCurrencyPairClassification(CurrencyPairClassification currencyPairClassification) {
			this.currencyPairClassification = currencyPairClassification==null?null:currencyPairClassification.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transmissionOfOrder")
		public ReportingRegime.ReportingRegimeBuilder setTransmissionOfOrder(Boolean transmissionOfOrder) {
			this.transmissionOfOrder = transmissionOfOrder==null?null:transmissionOfOrder;
			return this;
		}
		
		@Override
		public ReportingRegime build() {
			return new ReportingRegime.ReportingRegimeImpl(this);
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegime.ReportingRegimeBuilder prune() {
			if (reportingRegimeSequence0!=null && !reportingRegimeSequence0.prune().hasData()) reportingRegimeSequence0 = null;
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (mandatorilyClearable!=null && !mandatorilyClearable.prune().hasData()) mandatorilyClearable = null;
			if (reportingRegimeSequence1!=null && !reportingRegimeSequence1.prune().hasData()) reportingRegimeSequence1 = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (entityClassification!=null && !entityClassification.prune().hasData()) entityClassification = null;
			partyEntityClassification = partyEntityClassification.stream().filter(b->b!=null).<PartyEntityClassification.PartyEntityClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradePartyRelationshipType!=null && !tradePartyRelationshipType.prune().hasData()) tradePartyRelationshipType = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			if (notionalType!=null && !notionalType.prune().hasData()) notionalType = null;
			if (currencyPairClassification!=null && !currencyPairClassification.prune().hasData()) currencyPairClassification = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportingRegimeSequence0()!=null && getReportingRegimeSequence0().hasData()) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMandatorilyClearable()!=null && getMandatorilyClearable().hasData()) return true;
			if (getReportingRegimeSequence1()!=null && getReportingRegimeSequence1().hasData()) return true;
			if (getExceedsClearingThreshold()!=null) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEntityClassification()!=null && getEntityClassification().hasData()) return true;
			if (getPartyEntityClassification()!=null && getPartyEntityClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradePartyRelationshipType()!=null && getTradePartyRelationshipType().hasData()) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			if (getPreEnactmentTrade()!=null) return true;
			if (getNotionalType()!=null && getNotionalType().hasData()) return true;
			if (getCurrencyPairClassification()!=null && getCurrencyPairClassification().hasData()) return true;
			if (getTransmissionOfOrder()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegime.ReportingRegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegime.ReportingRegimeBuilder o = (ReportingRegime.ReportingRegimeBuilder) other;
			
			merger.mergeRosetta(getReportingRegimeSequence0(), o.getReportingRegimeSequence0(), this::setReportingRegimeSequence0);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			merger.mergeRosetta(getReportingRegimeSequence1(), o.getReportingRegimeSequence1(), this::setReportingRegimeSequence1);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getEntityClassification(), o.getEntityClassification(), this::setEntityClassification);
			merger.mergeRosetta(getPartyEntityClassification(), o.getPartyEntityClassification(), this::getOrCreatePartyEntityClassification);
			merger.mergeRosetta(getTradePartyRelationshipType(), o.getTradePartyRelationshipType(), this::setTradePartyRelationshipType);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeRosetta(getNotionalType(), o.getNotionalType(), this::setNotionalType);
			merger.mergeRosetta(getCurrencyPairClassification(), o.getCurrencyPairClassification(), this::setCurrencyPairClassification);
			
			merger.mergeBasic(getExceedsClearingThreshold(), o.getExceedsClearingThreshold(), this::setExceedsClearingThreshold);
			merger.mergeBasic(getPreEnactmentTrade(), o.getPreEnactmentTrade(), this::setPreEnactmentTrade);
			merger.mergeBasic(getTransmissionOfOrder(), o.getTransmissionOfOrder(), this::setTransmissionOfOrder);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegime _that = getType().cast(o);
		
			if (!Objects.equals(reportingRegimeSequence0, _that.getReportingRegimeSequence0())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(reportingRegimeSequence1, _that.getReportingRegimeSequence1())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			if (!ListEquals.listEquals(partyEntityClassification, _that.getPartyEntityClassification())) return false;
			if (!Objects.equals(tradePartyRelationshipType, _that.getTradePartyRelationshipType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(preEnactmentTrade, _that.getPreEnactmentTrade())) return false;
			if (!Objects.equals(notionalType, _that.getNotionalType())) return false;
			if (!Objects.equals(currencyPairClassification, _that.getCurrencyPairClassification())) return false;
			if (!Objects.equals(transmissionOfOrder, _that.getTransmissionOfOrder())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingRegimeSequence0 != null ? reportingRegimeSequence0.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (reportingRegimeSequence1 != null ? reportingRegimeSequence1.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			_result = 31 * _result + (partyEntityClassification != null ? partyEntityClassification.hashCode() : 0);
			_result = 31 * _result + (tradePartyRelationshipType != null ? tradePartyRelationshipType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (preEnactmentTrade != null ? preEnactmentTrade.hashCode() : 0);
			_result = 31 * _result + (notionalType != null ? notionalType.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassification != null ? currencyPairClassification.hashCode() : 0);
			_result = 31 * _result + (transmissionOfOrder != null ? transmissionOfOrder.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeBuilder {" +
				"reportingRegimeSequence0=" + this.reportingRegimeSequence0 + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"reportingRegimeSequence1=" + this.reportingRegimeSequence1 + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"entityClassification=" + this.entityClassification + ", " +
				"partyEntityClassification=" + this.partyEntityClassification + ", " +
				"tradePartyRelationshipType=" + this.tradePartyRelationshipType + ", " +
				"actionType=" + this.actionType + ", " +
				"preEnactmentTrade=" + this.preEnactmentTrade + ", " +
				"notionalType=" + this.notionalType + ", " +
				"currencyPairClassification=" + this.currencyPairClassification + ", " +
				"transmissionOfOrder=" + this.transmissionOfOrder +
			'}';
		}
	}
}
