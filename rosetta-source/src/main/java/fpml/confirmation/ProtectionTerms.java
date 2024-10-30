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
import fpml.confirmation.CreditEvents;
import fpml.confirmation.FloatingAmountEvents;
import fpml.confirmation.Money;
import fpml.confirmation.Obligations;
import fpml.confirmation.ProtectionTerms;
import fpml.confirmation.ProtectionTerms.ProtectionTermsBuilder;
import fpml.confirmation.ProtectionTerms.ProtectionTermsBuilderImpl;
import fpml.confirmation.ProtectionTerms.ProtectionTermsImpl;
import fpml.confirmation.meta.ProtectionTermsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ProtectionTerms", builder=ProtectionTerms.ProtectionTermsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ProtectionTerms extends RosettaModelObject {

	ProtectionTermsMeta metaData = new ProtectionTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The notional amount of protection coverage. ISDA 2003 Term: Floating Rate Payer Calculation Amount
	 */
	Money getCalculationAmount();
	/**
	 * This element contains all the ISDA terms relating to credit events.
	 */
	CreditEvents getCreditEvents();
	/**
	 * The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations. ISDA 2003 Term:
	 */
	Obligations getObligations();
	/**
	 * This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
	 */
	FloatingAmountEvents getFloatingAmountEvents();
	String getId();

	/*********************** Build Methods  ***********************/
	ProtectionTerms build();
	
	ProtectionTerms.ProtectionTermsBuilder toBuilder();
	
	static ProtectionTerms.ProtectionTermsBuilder builder() {
		return new ProtectionTerms.ProtectionTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProtectionTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProtectionTerms> getType() {
		return ProtectionTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAmount"), processor, Money.class, getCalculationAmount());
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("obligations"), processor, Obligations.class, getObligations());
		processRosetta(path.newSubPath("floatingAmountEvents"), processor, FloatingAmountEvents.class, getFloatingAmountEvents());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProtectionTermsBuilder extends ProtectionTerms, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCalculationAmount();
		Money.MoneyBuilder getCalculationAmount();
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		CreditEvents.CreditEventsBuilder getCreditEvents();
		Obligations.ObligationsBuilder getOrCreateObligations();
		Obligations.ObligationsBuilder getObligations();
		FloatingAmountEvents.FloatingAmountEventsBuilder getOrCreateFloatingAmountEvents();
		FloatingAmountEvents.FloatingAmountEventsBuilder getFloatingAmountEvents();
		ProtectionTerms.ProtectionTermsBuilder setCalculationAmount(Money calculationAmount);
		ProtectionTerms.ProtectionTermsBuilder setCreditEvents(CreditEvents creditEvents);
		ProtectionTerms.ProtectionTermsBuilder setObligations(Obligations obligations);
		ProtectionTerms.ProtectionTermsBuilder setFloatingAmountEvents(FloatingAmountEvents floatingAmountEvents);
		ProtectionTerms.ProtectionTermsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAmount"), processor, Money.MoneyBuilder.class, getCalculationAmount());
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("obligations"), processor, Obligations.ObligationsBuilder.class, getObligations());
			processRosetta(path.newSubPath("floatingAmountEvents"), processor, FloatingAmountEvents.FloatingAmountEventsBuilder.class, getFloatingAmountEvents());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ProtectionTerms.ProtectionTermsBuilder prune();
	}

	/*********************** Immutable Implementation of ProtectionTerms  ***********************/
	class ProtectionTermsImpl implements ProtectionTerms {
		private final Money calculationAmount;
		private final CreditEvents creditEvents;
		private final Obligations obligations;
		private final FloatingAmountEvents floatingAmountEvents;
		private final String id;
		
		protected ProtectionTermsImpl(ProtectionTerms.ProtectionTermsBuilder builder) {
			this.calculationAmount = ofNullable(builder.getCalculationAmount()).map(f->f.build()).orElse(null);
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.obligations = ofNullable(builder.getObligations()).map(f->f.build()).orElse(null);
			this.floatingAmountEvents = ofNullable(builder.getFloatingAmountEvents()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		public Money getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		@RosettaAttribute("obligations")
		public Obligations getObligations() {
			return obligations;
		}
		
		@Override
		@RosettaAttribute("floatingAmountEvents")
		public FloatingAmountEvents getFloatingAmountEvents() {
			return floatingAmountEvents;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ProtectionTerms build() {
			return this;
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder toBuilder() {
			ProtectionTerms.ProtectionTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProtectionTerms.ProtectionTermsBuilder builder) {
			ofNullable(getCalculationAmount()).ifPresent(builder::setCalculationAmount);
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getObligations()).ifPresent(builder::setObligations);
			ofNullable(getFloatingAmountEvents()).ifPresent(builder::setFloatingAmountEvents);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProtectionTerms _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(floatingAmountEvents, _that.getFloatingAmountEvents())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (floatingAmountEvents != null ? floatingAmountEvents.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProtectionTerms {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"obligations=" + this.obligations + ", " +
				"floatingAmountEvents=" + this.floatingAmountEvents + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ProtectionTerms  ***********************/
	class ProtectionTermsBuilderImpl implements ProtectionTerms.ProtectionTermsBuilder {
	
		protected Money.MoneyBuilder calculationAmount;
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected Obligations.ObligationsBuilder obligations;
		protected FloatingAmountEvents.FloatingAmountEventsBuilder floatingAmountEvents;
		protected String id;
	
		public ProtectionTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationAmount")
		public Money.MoneyBuilder getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCalculationAmount() {
			Money.MoneyBuilder result;
			if (calculationAmount!=null) {
				result = calculationAmount;
			}
			else {
				result = calculationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("obligations")
		public Obligations.ObligationsBuilder getObligations() {
			return obligations;
		}
		
		@Override
		public Obligations.ObligationsBuilder getOrCreateObligations() {
			Obligations.ObligationsBuilder result;
			if (obligations!=null) {
				result = obligations;
			}
			else {
				result = obligations = Obligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingAmountEvents")
		public FloatingAmountEvents.FloatingAmountEventsBuilder getFloatingAmountEvents() {
			return floatingAmountEvents;
		}
		
		@Override
		public FloatingAmountEvents.FloatingAmountEventsBuilder getOrCreateFloatingAmountEvents() {
			FloatingAmountEvents.FloatingAmountEventsBuilder result;
			if (floatingAmountEvents!=null) {
				result = floatingAmountEvents;
			}
			else {
				result = floatingAmountEvents = FloatingAmountEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		public ProtectionTerms.ProtectionTermsBuilder setCalculationAmount(Money calculationAmount) {
			this.calculationAmount = calculationAmount==null?null:calculationAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEvents")
		public ProtectionTerms.ProtectionTermsBuilder setCreditEvents(CreditEvents creditEvents) {
			this.creditEvents = creditEvents==null?null:creditEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("obligations")
		public ProtectionTerms.ProtectionTermsBuilder setObligations(Obligations obligations) {
			this.obligations = obligations==null?null:obligations.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingAmountEvents")
		public ProtectionTerms.ProtectionTermsBuilder setFloatingAmountEvents(FloatingAmountEvents floatingAmountEvents) {
			this.floatingAmountEvents = floatingAmountEvents==null?null:floatingAmountEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ProtectionTerms.ProtectionTermsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ProtectionTerms build() {
			return new ProtectionTerms.ProtectionTermsImpl(this);
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder prune() {
			if (calculationAmount!=null && !calculationAmount.prune().hasData()) calculationAmount = null;
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (obligations!=null && !obligations.prune().hasData()) obligations = null;
			if (floatingAmountEvents!=null && !floatingAmountEvents.prune().hasData()) floatingAmountEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAmount()!=null && getCalculationAmount().hasData()) return true;
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getObligations()!=null && getObligations().hasData()) return true;
			if (getFloatingAmountEvents()!=null && getFloatingAmountEvents().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProtectionTerms.ProtectionTermsBuilder o = (ProtectionTerms.ProtectionTermsBuilder) other;
			
			merger.mergeRosetta(getCalculationAmount(), o.getCalculationAmount(), this::setCalculationAmount);
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getObligations(), o.getObligations(), this::setObligations);
			merger.mergeRosetta(getFloatingAmountEvents(), o.getFloatingAmountEvents(), this::setFloatingAmountEvents);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProtectionTerms _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(floatingAmountEvents, _that.getFloatingAmountEvents())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (floatingAmountEvents != null ? floatingAmountEvents.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProtectionTermsBuilder {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"obligations=" + this.obligations + ", " +
				"floatingAmountEvents=" + this.floatingAmountEvents + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
