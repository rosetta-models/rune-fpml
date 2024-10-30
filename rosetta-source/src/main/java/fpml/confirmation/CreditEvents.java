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
import fpml.confirmation.CreditEventNoticeType;
import fpml.confirmation.CreditEvents;
import fpml.confirmation.CreditEvents.CreditEventsBuilder;
import fpml.confirmation.CreditEvents.CreditEventsBuilderImpl;
import fpml.confirmation.CreditEvents.CreditEventsImpl;
import fpml.confirmation.FailureToPayType;
import fpml.confirmation.Money;
import fpml.confirmation.Restructuring;
import fpml.confirmation.meta.CreditEventsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditEvents", builder=CreditEvents.CreditEventsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditEvents extends RosettaModelObject {

	CreditEventsMeta metaData = new CreditEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A credit event. The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as &quot;technically&quot; a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
	 */
	Boolean getBankruptcy();
	/**
	 * A credit event. This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregrate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
	 */
	FailureToPayType getFailureToPay();
	/**
	 * A credit event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
	 */
	Boolean getFailureToPayPrincipal();
	/**
	 * A credit event. Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
	 */
	Boolean getFailureToPayInterest();
	/**
	 * A credit event. One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
	 */
	Boolean getObligationDefault();
	/**
	 * A credit event. One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
	 */
	Boolean getObligationAcceleration();
	/**
	 * A credit event. The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
	 */
	Boolean getRepudiationMoratorium();
	/**
	 * A credit event. A restructuring is an event that materially impacts the reference entity&#39;s obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
	 */
	Restructuring getRestructuring();
	/**
	 * A credit event. A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity&#39;s obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
	 */
	Boolean getGovernmentalIntervention();
	/**
	 * A credit event. Results from the fact that the rating of the reference obligation is downgraded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
	 */
	Boolean getDistressedRatingsDowngrade();
	/**
	 * A credit event. Results from the fact that the underlier fails to make principal payments as expected.
	 */
	Boolean getMaturityExtension();
	/**
	 * A credit event. Results from the fact that the underlier writes down its outstanding principal amount.
	 */
	Boolean getWritedown();
	/**
	 * A credit event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
	 */
	Boolean getImpliedWritedown();
	/**
	 * In relation to certain credit events, serves as a threshold for Obligation Acceleration, Obligation Default, Repudiation/Moratorium and Restructuring. Market standard is USD 10,000,000 (JPY 1,000,000,000 for all Japanese Yen trades). This is applied on an aggregate or total basis across all Obligations of the Reference Entity. Used to prevent technical/operational errors from triggering credit events. ISDA 2003 Term: Default Requirement.
	 */
	Money getDefaultRequirement();
	/**
	 * A specified condition to settlement. An irrevocable written or verbal notice that describes a credit event that has occurred. The notice is sent from the notifying party (either the buyer or the seller) to the counterparty. It provides information relevant to determining that a credit event has occurred. This is typically accompanied by Publicly Available Information. ISDA 2003 Term: Credit Event Notice.
	 */
	CreditEventNoticeType getCreditEventNotice();
	String getId();

	/*********************** Build Methods  ***********************/
	CreditEvents build();
	
	CreditEvents.CreditEventsBuilder toBuilder();
	
	static CreditEvents.CreditEventsBuilder builder() {
		return new CreditEvents.CreditEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEvents> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEvents> getType() {
		return CreditEvents.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bankruptcy"), Boolean.class, getBankruptcy(), this);
		processRosetta(path.newSubPath("failureToPay"), processor, FailureToPayType.class, getFailureToPay());
		processor.processBasic(path.newSubPath("failureToPayPrincipal"), Boolean.class, getFailureToPayPrincipal(), this);
		processor.processBasic(path.newSubPath("failureToPayInterest"), Boolean.class, getFailureToPayInterest(), this);
		processor.processBasic(path.newSubPath("obligationDefault"), Boolean.class, getObligationDefault(), this);
		processor.processBasic(path.newSubPath("obligationAcceleration"), Boolean.class, getObligationAcceleration(), this);
		processor.processBasic(path.newSubPath("repudiationMoratorium"), Boolean.class, getRepudiationMoratorium(), this);
		processRosetta(path.newSubPath("restructuring"), processor, Restructuring.class, getRestructuring());
		processor.processBasic(path.newSubPath("governmentalIntervention"), Boolean.class, getGovernmentalIntervention(), this);
		processor.processBasic(path.newSubPath("distressedRatingsDowngrade"), Boolean.class, getDistressedRatingsDowngrade(), this);
		processor.processBasic(path.newSubPath("maturityExtension"), Boolean.class, getMaturityExtension(), this);
		processor.processBasic(path.newSubPath("writedown"), Boolean.class, getWritedown(), this);
		processor.processBasic(path.newSubPath("impliedWritedown"), Boolean.class, getImpliedWritedown(), this);
		processRosetta(path.newSubPath("defaultRequirement"), processor, Money.class, getDefaultRequirement());
		processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeType.class, getCreditEventNotice());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventsBuilder extends CreditEvents, RosettaModelObjectBuilder {
		FailureToPayType.FailureToPayTypeBuilder getOrCreateFailureToPay();
		FailureToPayType.FailureToPayTypeBuilder getFailureToPay();
		Restructuring.RestructuringBuilder getOrCreateRestructuring();
		Restructuring.RestructuringBuilder getRestructuring();
		Money.MoneyBuilder getOrCreateDefaultRequirement();
		Money.MoneyBuilder getDefaultRequirement();
		CreditEventNoticeType.CreditEventNoticeTypeBuilder getOrCreateCreditEventNotice();
		CreditEventNoticeType.CreditEventNoticeTypeBuilder getCreditEventNotice();
		CreditEvents.CreditEventsBuilder setBankruptcy(Boolean bankruptcy);
		CreditEvents.CreditEventsBuilder setFailureToPay(FailureToPayType failureToPay);
		CreditEvents.CreditEventsBuilder setFailureToPayPrincipal(Boolean failureToPayPrincipal);
		CreditEvents.CreditEventsBuilder setFailureToPayInterest(Boolean failureToPayInterest);
		CreditEvents.CreditEventsBuilder setObligationDefault(Boolean obligationDefault);
		CreditEvents.CreditEventsBuilder setObligationAcceleration(Boolean obligationAcceleration);
		CreditEvents.CreditEventsBuilder setRepudiationMoratorium(Boolean repudiationMoratorium);
		CreditEvents.CreditEventsBuilder setRestructuring(Restructuring restructuring);
		CreditEvents.CreditEventsBuilder setGovernmentalIntervention(Boolean governmentalIntervention);
		CreditEvents.CreditEventsBuilder setDistressedRatingsDowngrade(Boolean distressedRatingsDowngrade);
		CreditEvents.CreditEventsBuilder setMaturityExtension(Boolean maturityExtension);
		CreditEvents.CreditEventsBuilder setWritedown(Boolean writedown);
		CreditEvents.CreditEventsBuilder setImpliedWritedown(Boolean impliedWritedown);
		CreditEvents.CreditEventsBuilder setDefaultRequirement(Money defaultRequirement);
		CreditEvents.CreditEventsBuilder setCreditEventNotice(CreditEventNoticeType creditEventNotice);
		CreditEvents.CreditEventsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("bankruptcy"), Boolean.class, getBankruptcy(), this);
			processRosetta(path.newSubPath("failureToPay"), processor, FailureToPayType.FailureToPayTypeBuilder.class, getFailureToPay());
			processor.processBasic(path.newSubPath("failureToPayPrincipal"), Boolean.class, getFailureToPayPrincipal(), this);
			processor.processBasic(path.newSubPath("failureToPayInterest"), Boolean.class, getFailureToPayInterest(), this);
			processor.processBasic(path.newSubPath("obligationDefault"), Boolean.class, getObligationDefault(), this);
			processor.processBasic(path.newSubPath("obligationAcceleration"), Boolean.class, getObligationAcceleration(), this);
			processor.processBasic(path.newSubPath("repudiationMoratorium"), Boolean.class, getRepudiationMoratorium(), this);
			processRosetta(path.newSubPath("restructuring"), processor, Restructuring.RestructuringBuilder.class, getRestructuring());
			processor.processBasic(path.newSubPath("governmentalIntervention"), Boolean.class, getGovernmentalIntervention(), this);
			processor.processBasic(path.newSubPath("distressedRatingsDowngrade"), Boolean.class, getDistressedRatingsDowngrade(), this);
			processor.processBasic(path.newSubPath("maturityExtension"), Boolean.class, getMaturityExtension(), this);
			processor.processBasic(path.newSubPath("writedown"), Boolean.class, getWritedown(), this);
			processor.processBasic(path.newSubPath("impliedWritedown"), Boolean.class, getImpliedWritedown(), this);
			processRosetta(path.newSubPath("defaultRequirement"), processor, Money.MoneyBuilder.class, getDefaultRequirement());
			processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeType.CreditEventNoticeTypeBuilder.class, getCreditEventNotice());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CreditEvents.CreditEventsBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEvents  ***********************/
	class CreditEventsImpl implements CreditEvents {
		private final Boolean bankruptcy;
		private final FailureToPayType failureToPay;
		private final Boolean failureToPayPrincipal;
		private final Boolean failureToPayInterest;
		private final Boolean obligationDefault;
		private final Boolean obligationAcceleration;
		private final Boolean repudiationMoratorium;
		private final Restructuring restructuring;
		private final Boolean governmentalIntervention;
		private final Boolean distressedRatingsDowngrade;
		private final Boolean maturityExtension;
		private final Boolean writedown;
		private final Boolean impliedWritedown;
		private final Money defaultRequirement;
		private final CreditEventNoticeType creditEventNotice;
		private final String id;
		
		protected CreditEventsImpl(CreditEvents.CreditEventsBuilder builder) {
			this.bankruptcy = builder.getBankruptcy();
			this.failureToPay = ofNullable(builder.getFailureToPay()).map(f->f.build()).orElse(null);
			this.failureToPayPrincipal = builder.getFailureToPayPrincipal();
			this.failureToPayInterest = builder.getFailureToPayInterest();
			this.obligationDefault = builder.getObligationDefault();
			this.obligationAcceleration = builder.getObligationAcceleration();
			this.repudiationMoratorium = builder.getRepudiationMoratorium();
			this.restructuring = ofNullable(builder.getRestructuring()).map(f->f.build()).orElse(null);
			this.governmentalIntervention = builder.getGovernmentalIntervention();
			this.distressedRatingsDowngrade = builder.getDistressedRatingsDowngrade();
			this.maturityExtension = builder.getMaturityExtension();
			this.writedown = builder.getWritedown();
			this.impliedWritedown = builder.getImpliedWritedown();
			this.defaultRequirement = ofNullable(builder.getDefaultRequirement()).map(f->f.build()).orElse(null);
			this.creditEventNotice = ofNullable(builder.getCreditEventNotice()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("bankruptcy")
		public Boolean getBankruptcy() {
			return bankruptcy;
		}
		
		@Override
		@RosettaAttribute("failureToPay")
		public FailureToPayType getFailureToPay() {
			return failureToPay;
		}
		
		@Override
		@RosettaAttribute("failureToPayPrincipal")
		public Boolean getFailureToPayPrincipal() {
			return failureToPayPrincipal;
		}
		
		@Override
		@RosettaAttribute("failureToPayInterest")
		public Boolean getFailureToPayInterest() {
			return failureToPayInterest;
		}
		
		@Override
		@RosettaAttribute("obligationDefault")
		public Boolean getObligationDefault() {
			return obligationDefault;
		}
		
		@Override
		@RosettaAttribute("obligationAcceleration")
		public Boolean getObligationAcceleration() {
			return obligationAcceleration;
		}
		
		@Override
		@RosettaAttribute("repudiationMoratorium")
		public Boolean getRepudiationMoratorium() {
			return repudiationMoratorium;
		}
		
		@Override
		@RosettaAttribute("restructuring")
		public Restructuring getRestructuring() {
			return restructuring;
		}
		
		@Override
		@RosettaAttribute("governmentalIntervention")
		public Boolean getGovernmentalIntervention() {
			return governmentalIntervention;
		}
		
		@Override
		@RosettaAttribute("distressedRatingsDowngrade")
		public Boolean getDistressedRatingsDowngrade() {
			return distressedRatingsDowngrade;
		}
		
		@Override
		@RosettaAttribute("maturityExtension")
		public Boolean getMaturityExtension() {
			return maturityExtension;
		}
		
		@Override
		@RosettaAttribute("writedown")
		public Boolean getWritedown() {
			return writedown;
		}
		
		@Override
		@RosettaAttribute("impliedWritedown")
		public Boolean getImpliedWritedown() {
			return impliedWritedown;
		}
		
		@Override
		@RosettaAttribute("defaultRequirement")
		public Money getDefaultRequirement() {
			return defaultRequirement;
		}
		
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEventNoticeType getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CreditEvents build() {
			return this;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder toBuilder() {
			CreditEvents.CreditEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEvents.CreditEventsBuilder builder) {
			ofNullable(getBankruptcy()).ifPresent(builder::setBankruptcy);
			ofNullable(getFailureToPay()).ifPresent(builder::setFailureToPay);
			ofNullable(getFailureToPayPrincipal()).ifPresent(builder::setFailureToPayPrincipal);
			ofNullable(getFailureToPayInterest()).ifPresent(builder::setFailureToPayInterest);
			ofNullable(getObligationDefault()).ifPresent(builder::setObligationDefault);
			ofNullable(getObligationAcceleration()).ifPresent(builder::setObligationAcceleration);
			ofNullable(getRepudiationMoratorium()).ifPresent(builder::setRepudiationMoratorium);
			ofNullable(getRestructuring()).ifPresent(builder::setRestructuring);
			ofNullable(getGovernmentalIntervention()).ifPresent(builder::setGovernmentalIntervention);
			ofNullable(getDistressedRatingsDowngrade()).ifPresent(builder::setDistressedRatingsDowngrade);
			ofNullable(getMaturityExtension()).ifPresent(builder::setMaturityExtension);
			ofNullable(getWritedown()).ifPresent(builder::setWritedown);
			ofNullable(getImpliedWritedown()).ifPresent(builder::setImpliedWritedown);
			ofNullable(getDefaultRequirement()).ifPresent(builder::setDefaultRequirement);
			ofNullable(getCreditEventNotice()).ifPresent(builder::setCreditEventNotice);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEvents _that = getType().cast(o);
		
			if (!Objects.equals(bankruptcy, _that.getBankruptcy())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			if (!Objects.equals(failureToPayPrincipal, _that.getFailureToPayPrincipal())) return false;
			if (!Objects.equals(failureToPayInterest, _that.getFailureToPayInterest())) return false;
			if (!Objects.equals(obligationDefault, _that.getObligationDefault())) return false;
			if (!Objects.equals(obligationAcceleration, _that.getObligationAcceleration())) return false;
			if (!Objects.equals(repudiationMoratorium, _that.getRepudiationMoratorium())) return false;
			if (!Objects.equals(restructuring, _that.getRestructuring())) return false;
			if (!Objects.equals(governmentalIntervention, _that.getGovernmentalIntervention())) return false;
			if (!Objects.equals(distressedRatingsDowngrade, _that.getDistressedRatingsDowngrade())) return false;
			if (!Objects.equals(maturityExtension, _that.getMaturityExtension())) return false;
			if (!Objects.equals(writedown, _that.getWritedown())) return false;
			if (!Objects.equals(impliedWritedown, _that.getImpliedWritedown())) return false;
			if (!Objects.equals(defaultRequirement, _that.getDefaultRequirement())) return false;
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bankruptcy != null ? bankruptcy.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			_result = 31 * _result + (failureToPayPrincipal != null ? failureToPayPrincipal.hashCode() : 0);
			_result = 31 * _result + (failureToPayInterest != null ? failureToPayInterest.hashCode() : 0);
			_result = 31 * _result + (obligationDefault != null ? obligationDefault.hashCode() : 0);
			_result = 31 * _result + (obligationAcceleration != null ? obligationAcceleration.hashCode() : 0);
			_result = 31 * _result + (repudiationMoratorium != null ? repudiationMoratorium.hashCode() : 0);
			_result = 31 * _result + (restructuring != null ? restructuring.hashCode() : 0);
			_result = 31 * _result + (governmentalIntervention != null ? governmentalIntervention.hashCode() : 0);
			_result = 31 * _result + (distressedRatingsDowngrade != null ? distressedRatingsDowngrade.hashCode() : 0);
			_result = 31 * _result + (maturityExtension != null ? maturityExtension.hashCode() : 0);
			_result = 31 * _result + (writedown != null ? writedown.hashCode() : 0);
			_result = 31 * _result + (impliedWritedown != null ? impliedWritedown.hashCode() : 0);
			_result = 31 * _result + (defaultRequirement != null ? defaultRequirement.hashCode() : 0);
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEvents {" +
				"bankruptcy=" + this.bankruptcy + ", " +
				"failureToPay=" + this.failureToPay + ", " +
				"failureToPayPrincipal=" + this.failureToPayPrincipal + ", " +
				"failureToPayInterest=" + this.failureToPayInterest + ", " +
				"obligationDefault=" + this.obligationDefault + ", " +
				"obligationAcceleration=" + this.obligationAcceleration + ", " +
				"repudiationMoratorium=" + this.repudiationMoratorium + ", " +
				"restructuring=" + this.restructuring + ", " +
				"governmentalIntervention=" + this.governmentalIntervention + ", " +
				"distressedRatingsDowngrade=" + this.distressedRatingsDowngrade + ", " +
				"maturityExtension=" + this.maturityExtension + ", " +
				"writedown=" + this.writedown + ", " +
				"impliedWritedown=" + this.impliedWritedown + ", " +
				"defaultRequirement=" + this.defaultRequirement + ", " +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEvents  ***********************/
	class CreditEventsBuilderImpl implements CreditEvents.CreditEventsBuilder {
	
		protected Boolean bankruptcy;
		protected FailureToPayType.FailureToPayTypeBuilder failureToPay;
		protected Boolean failureToPayPrincipal;
		protected Boolean failureToPayInterest;
		protected Boolean obligationDefault;
		protected Boolean obligationAcceleration;
		protected Boolean repudiationMoratorium;
		protected Restructuring.RestructuringBuilder restructuring;
		protected Boolean governmentalIntervention;
		protected Boolean distressedRatingsDowngrade;
		protected Boolean maturityExtension;
		protected Boolean writedown;
		protected Boolean impliedWritedown;
		protected Money.MoneyBuilder defaultRequirement;
		protected CreditEventNoticeType.CreditEventNoticeTypeBuilder creditEventNotice;
		protected String id;
	
		public CreditEventsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bankruptcy")
		public Boolean getBankruptcy() {
			return bankruptcy;
		}
		
		@Override
		@RosettaAttribute("failureToPay")
		public FailureToPayType.FailureToPayTypeBuilder getFailureToPay() {
			return failureToPay;
		}
		
		@Override
		public FailureToPayType.FailureToPayTypeBuilder getOrCreateFailureToPay() {
			FailureToPayType.FailureToPayTypeBuilder result;
			if (failureToPay!=null) {
				result = failureToPay;
			}
			else {
				result = failureToPay = FailureToPayType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("failureToPayPrincipal")
		public Boolean getFailureToPayPrincipal() {
			return failureToPayPrincipal;
		}
		
		@Override
		@RosettaAttribute("failureToPayInterest")
		public Boolean getFailureToPayInterest() {
			return failureToPayInterest;
		}
		
		@Override
		@RosettaAttribute("obligationDefault")
		public Boolean getObligationDefault() {
			return obligationDefault;
		}
		
		@Override
		@RosettaAttribute("obligationAcceleration")
		public Boolean getObligationAcceleration() {
			return obligationAcceleration;
		}
		
		@Override
		@RosettaAttribute("repudiationMoratorium")
		public Boolean getRepudiationMoratorium() {
			return repudiationMoratorium;
		}
		
		@Override
		@RosettaAttribute("restructuring")
		public Restructuring.RestructuringBuilder getRestructuring() {
			return restructuring;
		}
		
		@Override
		public Restructuring.RestructuringBuilder getOrCreateRestructuring() {
			Restructuring.RestructuringBuilder result;
			if (restructuring!=null) {
				result = restructuring;
			}
			else {
				result = restructuring = Restructuring.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("governmentalIntervention")
		public Boolean getGovernmentalIntervention() {
			return governmentalIntervention;
		}
		
		@Override
		@RosettaAttribute("distressedRatingsDowngrade")
		public Boolean getDistressedRatingsDowngrade() {
			return distressedRatingsDowngrade;
		}
		
		@Override
		@RosettaAttribute("maturityExtension")
		public Boolean getMaturityExtension() {
			return maturityExtension;
		}
		
		@Override
		@RosettaAttribute("writedown")
		public Boolean getWritedown() {
			return writedown;
		}
		
		@Override
		@RosettaAttribute("impliedWritedown")
		public Boolean getImpliedWritedown() {
			return impliedWritedown;
		}
		
		@Override
		@RosettaAttribute("defaultRequirement")
		public Money.MoneyBuilder getDefaultRequirement() {
			return defaultRequirement;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateDefaultRequirement() {
			Money.MoneyBuilder result;
			if (defaultRequirement!=null) {
				result = defaultRequirement;
			}
			else {
				result = defaultRequirement = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder getOrCreateCreditEventNotice() {
			CreditEventNoticeType.CreditEventNoticeTypeBuilder result;
			if (creditEventNotice!=null) {
				result = creditEventNotice;
			}
			else {
				result = creditEventNotice = CreditEventNoticeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("bankruptcy")
		public CreditEvents.CreditEventsBuilder setBankruptcy(Boolean bankruptcy) {
			this.bankruptcy = bankruptcy==null?null:bankruptcy;
			return this;
		}
		@Override
		@RosettaAttribute("failureToPay")
		public CreditEvents.CreditEventsBuilder setFailureToPay(FailureToPayType failureToPay) {
			this.failureToPay = failureToPay==null?null:failureToPay.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("failureToPayPrincipal")
		public CreditEvents.CreditEventsBuilder setFailureToPayPrincipal(Boolean failureToPayPrincipal) {
			this.failureToPayPrincipal = failureToPayPrincipal==null?null:failureToPayPrincipal;
			return this;
		}
		@Override
		@RosettaAttribute("failureToPayInterest")
		public CreditEvents.CreditEventsBuilder setFailureToPayInterest(Boolean failureToPayInterest) {
			this.failureToPayInterest = failureToPayInterest==null?null:failureToPayInterest;
			return this;
		}
		@Override
		@RosettaAttribute("obligationDefault")
		public CreditEvents.CreditEventsBuilder setObligationDefault(Boolean obligationDefault) {
			this.obligationDefault = obligationDefault==null?null:obligationDefault;
			return this;
		}
		@Override
		@RosettaAttribute("obligationAcceleration")
		public CreditEvents.CreditEventsBuilder setObligationAcceleration(Boolean obligationAcceleration) {
			this.obligationAcceleration = obligationAcceleration==null?null:obligationAcceleration;
			return this;
		}
		@Override
		@RosettaAttribute("repudiationMoratorium")
		public CreditEvents.CreditEventsBuilder setRepudiationMoratorium(Boolean repudiationMoratorium) {
			this.repudiationMoratorium = repudiationMoratorium==null?null:repudiationMoratorium;
			return this;
		}
		@Override
		@RosettaAttribute("restructuring")
		public CreditEvents.CreditEventsBuilder setRestructuring(Restructuring restructuring) {
			this.restructuring = restructuring==null?null:restructuring.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governmentalIntervention")
		public CreditEvents.CreditEventsBuilder setGovernmentalIntervention(Boolean governmentalIntervention) {
			this.governmentalIntervention = governmentalIntervention==null?null:governmentalIntervention;
			return this;
		}
		@Override
		@RosettaAttribute("distressedRatingsDowngrade")
		public CreditEvents.CreditEventsBuilder setDistressedRatingsDowngrade(Boolean distressedRatingsDowngrade) {
			this.distressedRatingsDowngrade = distressedRatingsDowngrade==null?null:distressedRatingsDowngrade;
			return this;
		}
		@Override
		@RosettaAttribute("maturityExtension")
		public CreditEvents.CreditEventsBuilder setMaturityExtension(Boolean maturityExtension) {
			this.maturityExtension = maturityExtension==null?null:maturityExtension;
			return this;
		}
		@Override
		@RosettaAttribute("writedown")
		public CreditEvents.CreditEventsBuilder setWritedown(Boolean writedown) {
			this.writedown = writedown==null?null:writedown;
			return this;
		}
		@Override
		@RosettaAttribute("impliedWritedown")
		public CreditEvents.CreditEventsBuilder setImpliedWritedown(Boolean impliedWritedown) {
			this.impliedWritedown = impliedWritedown==null?null:impliedWritedown;
			return this;
		}
		@Override
		@RosettaAttribute("defaultRequirement")
		public CreditEvents.CreditEventsBuilder setDefaultRequirement(Money defaultRequirement) {
			this.defaultRequirement = defaultRequirement==null?null:defaultRequirement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEvents.CreditEventsBuilder setCreditEventNotice(CreditEventNoticeType creditEventNotice) {
			this.creditEventNotice = creditEventNotice==null?null:creditEventNotice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CreditEvents.CreditEventsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CreditEvents build() {
			return new CreditEvents.CreditEventsImpl(this);
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvents.CreditEventsBuilder prune() {
			if (failureToPay!=null && !failureToPay.prune().hasData()) failureToPay = null;
			if (restructuring!=null && !restructuring.prune().hasData()) restructuring = null;
			if (defaultRequirement!=null && !defaultRequirement.prune().hasData()) defaultRequirement = null;
			if (creditEventNotice!=null && !creditEventNotice.prune().hasData()) creditEventNotice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBankruptcy()!=null) return true;
			if (getFailureToPay()!=null && getFailureToPay().hasData()) return true;
			if (getFailureToPayPrincipal()!=null) return true;
			if (getFailureToPayInterest()!=null) return true;
			if (getObligationDefault()!=null) return true;
			if (getObligationAcceleration()!=null) return true;
			if (getRepudiationMoratorium()!=null) return true;
			if (getRestructuring()!=null && getRestructuring().hasData()) return true;
			if (getGovernmentalIntervention()!=null) return true;
			if (getDistressedRatingsDowngrade()!=null) return true;
			if (getMaturityExtension()!=null) return true;
			if (getWritedown()!=null) return true;
			if (getImpliedWritedown()!=null) return true;
			if (getDefaultRequirement()!=null && getDefaultRequirement().hasData()) return true;
			if (getCreditEventNotice()!=null && getCreditEventNotice().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvents.CreditEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEvents.CreditEventsBuilder o = (CreditEvents.CreditEventsBuilder) other;
			
			merger.mergeRosetta(getFailureToPay(), o.getFailureToPay(), this::setFailureToPay);
			merger.mergeRosetta(getRestructuring(), o.getRestructuring(), this::setRestructuring);
			merger.mergeRosetta(getDefaultRequirement(), o.getDefaultRequirement(), this::setDefaultRequirement);
			merger.mergeRosetta(getCreditEventNotice(), o.getCreditEventNotice(), this::setCreditEventNotice);
			
			merger.mergeBasic(getBankruptcy(), o.getBankruptcy(), this::setBankruptcy);
			merger.mergeBasic(getFailureToPayPrincipal(), o.getFailureToPayPrincipal(), this::setFailureToPayPrincipal);
			merger.mergeBasic(getFailureToPayInterest(), o.getFailureToPayInterest(), this::setFailureToPayInterest);
			merger.mergeBasic(getObligationDefault(), o.getObligationDefault(), this::setObligationDefault);
			merger.mergeBasic(getObligationAcceleration(), o.getObligationAcceleration(), this::setObligationAcceleration);
			merger.mergeBasic(getRepudiationMoratorium(), o.getRepudiationMoratorium(), this::setRepudiationMoratorium);
			merger.mergeBasic(getGovernmentalIntervention(), o.getGovernmentalIntervention(), this::setGovernmentalIntervention);
			merger.mergeBasic(getDistressedRatingsDowngrade(), o.getDistressedRatingsDowngrade(), this::setDistressedRatingsDowngrade);
			merger.mergeBasic(getMaturityExtension(), o.getMaturityExtension(), this::setMaturityExtension);
			merger.mergeBasic(getWritedown(), o.getWritedown(), this::setWritedown);
			merger.mergeBasic(getImpliedWritedown(), o.getImpliedWritedown(), this::setImpliedWritedown);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEvents _that = getType().cast(o);
		
			if (!Objects.equals(bankruptcy, _that.getBankruptcy())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			if (!Objects.equals(failureToPayPrincipal, _that.getFailureToPayPrincipal())) return false;
			if (!Objects.equals(failureToPayInterest, _that.getFailureToPayInterest())) return false;
			if (!Objects.equals(obligationDefault, _that.getObligationDefault())) return false;
			if (!Objects.equals(obligationAcceleration, _that.getObligationAcceleration())) return false;
			if (!Objects.equals(repudiationMoratorium, _that.getRepudiationMoratorium())) return false;
			if (!Objects.equals(restructuring, _that.getRestructuring())) return false;
			if (!Objects.equals(governmentalIntervention, _that.getGovernmentalIntervention())) return false;
			if (!Objects.equals(distressedRatingsDowngrade, _that.getDistressedRatingsDowngrade())) return false;
			if (!Objects.equals(maturityExtension, _that.getMaturityExtension())) return false;
			if (!Objects.equals(writedown, _that.getWritedown())) return false;
			if (!Objects.equals(impliedWritedown, _that.getImpliedWritedown())) return false;
			if (!Objects.equals(defaultRequirement, _that.getDefaultRequirement())) return false;
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bankruptcy != null ? bankruptcy.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			_result = 31 * _result + (failureToPayPrincipal != null ? failureToPayPrincipal.hashCode() : 0);
			_result = 31 * _result + (failureToPayInterest != null ? failureToPayInterest.hashCode() : 0);
			_result = 31 * _result + (obligationDefault != null ? obligationDefault.hashCode() : 0);
			_result = 31 * _result + (obligationAcceleration != null ? obligationAcceleration.hashCode() : 0);
			_result = 31 * _result + (repudiationMoratorium != null ? repudiationMoratorium.hashCode() : 0);
			_result = 31 * _result + (restructuring != null ? restructuring.hashCode() : 0);
			_result = 31 * _result + (governmentalIntervention != null ? governmentalIntervention.hashCode() : 0);
			_result = 31 * _result + (distressedRatingsDowngrade != null ? distressedRatingsDowngrade.hashCode() : 0);
			_result = 31 * _result + (maturityExtension != null ? maturityExtension.hashCode() : 0);
			_result = 31 * _result + (writedown != null ? writedown.hashCode() : 0);
			_result = 31 * _result + (impliedWritedown != null ? impliedWritedown.hashCode() : 0);
			_result = 31 * _result + (defaultRequirement != null ? defaultRequirement.hashCode() : 0);
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventsBuilder {" +
				"bankruptcy=" + this.bankruptcy + ", " +
				"failureToPay=" + this.failureToPay + ", " +
				"failureToPayPrincipal=" + this.failureToPayPrincipal + ", " +
				"failureToPayInterest=" + this.failureToPayInterest + ", " +
				"obligationDefault=" + this.obligationDefault + ", " +
				"obligationAcceleration=" + this.obligationAcceleration + ", " +
				"repudiationMoratorium=" + this.repudiationMoratorium + ", " +
				"restructuring=" + this.restructuring + ", " +
				"governmentalIntervention=" + this.governmentalIntervention + ", " +
				"distressedRatingsDowngrade=" + this.distressedRatingsDowngrade + ", " +
				"maturityExtension=" + this.maturityExtension + ", " +
				"writedown=" + this.writedown + ", " +
				"impliedWritedown=" + this.impliedWritedown + ", " +
				"defaultRequirement=" + this.defaultRequirement + ", " +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
