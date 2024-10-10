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
import fpml.confirmation.Currency;
import fpml.confirmation.NonDeliverableSettlement;
import fpml.confirmation.SettlementProvision;
import fpml.confirmation.SettlementProvision.SettlementProvisionBuilder;
import fpml.confirmation.SettlementProvision.SettlementProvisionBuilderImpl;
import fpml.confirmation.SettlementProvision.SettlementProvisionImpl;
import fpml.confirmation.meta.SettlementProvisionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the specification of settlement terms, occuring when the settlement currency is different to the notional currency of the trade.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementProvision", builder=SettlementProvision.SettlementProvisionBuilderImpl.class, version="${project.version}")
public interface SettlementProvision extends RosettaModelObject {

	SettlementProvisionMeta metaData = new SettlementProvisionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency that stream settles in (to support swaps that settle in a currency different from the notional currency).
	 */
	Currency getSettlementCurrency();
	/**
	 * The specification of the non-deliverable settlement provision.
	 */
	NonDeliverableSettlement getNonDeliverableSettlement();

	/*********************** Build Methods  ***********************/
	SettlementProvision build();
	
	SettlementProvision.SettlementProvisionBuilder toBuilder();
	
	static SettlementProvision.SettlementProvisionBuilder builder() {
		return new SettlementProvision.SettlementProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementProvision> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementProvision> getType() {
		return SettlementProvision.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("nonDeliverableSettlement"), processor, NonDeliverableSettlement.class, getNonDeliverableSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementProvisionBuilder extends SettlementProvision, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		Currency.CurrencyBuilder getSettlementCurrency();
		NonDeliverableSettlement.NonDeliverableSettlementBuilder getOrCreateNonDeliverableSettlement();
		NonDeliverableSettlement.NonDeliverableSettlementBuilder getNonDeliverableSettlement();
		SettlementProvision.SettlementProvisionBuilder setSettlementCurrency(Currency settlementCurrency);
		SettlementProvision.SettlementProvisionBuilder setNonDeliverableSettlement(NonDeliverableSettlement nonDeliverableSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("nonDeliverableSettlement"), processor, NonDeliverableSettlement.NonDeliverableSettlementBuilder.class, getNonDeliverableSettlement());
		}
		

		SettlementProvision.SettlementProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementProvision  ***********************/
	class SettlementProvisionImpl implements SettlementProvision {
		private final Currency settlementCurrency;
		private final NonDeliverableSettlement nonDeliverableSettlement;
		
		protected SettlementProvisionImpl(SettlementProvision.SettlementProvisionBuilder builder) {
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.nonDeliverableSettlement = ofNullable(builder.getNonDeliverableSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		public NonDeliverableSettlement getNonDeliverableSettlement() {
			return nonDeliverableSettlement;
		}
		
		@Override
		public SettlementProvision build() {
			return this;
		}
		
		@Override
		public SettlementProvision.SettlementProvisionBuilder toBuilder() {
			SettlementProvision.SettlementProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementProvision.SettlementProvisionBuilder builder) {
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getNonDeliverableSettlement()).ifPresent(builder::setNonDeliverableSettlement);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementProvision _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(nonDeliverableSettlement, _that.getNonDeliverableSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSettlement != null ? nonDeliverableSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementProvision {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"nonDeliverableSettlement=" + this.nonDeliverableSettlement +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementProvision  ***********************/
	class SettlementProvisionBuilderImpl implements SettlementProvision.SettlementProvisionBuilder {
	
		protected Currency.CurrencyBuilder settlementCurrency;
		protected NonDeliverableSettlement.NonDeliverableSettlementBuilder nonDeliverableSettlement;
	
		public SettlementProvisionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder getNonDeliverableSettlement() {
			return nonDeliverableSettlement;
		}
		
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder getOrCreateNonDeliverableSettlement() {
			NonDeliverableSettlement.NonDeliverableSettlementBuilder result;
			if (nonDeliverableSettlement!=null) {
				result = nonDeliverableSettlement;
			}
			else {
				result = nonDeliverableSettlement = NonDeliverableSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public SettlementProvision.SettlementProvisionBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("nonDeliverableSettlement")
		public SettlementProvision.SettlementProvisionBuilder setNonDeliverableSettlement(NonDeliverableSettlement nonDeliverableSettlement) {
			this.nonDeliverableSettlement = nonDeliverableSettlement==null?null:nonDeliverableSettlement.toBuilder();
			return this;
		}
		
		@Override
		public SettlementProvision build() {
			return new SettlementProvision.SettlementProvisionImpl(this);
		}
		
		@Override
		public SettlementProvision.SettlementProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementProvision.SettlementProvisionBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (nonDeliverableSettlement!=null && !nonDeliverableSettlement.prune().hasData()) nonDeliverableSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getNonDeliverableSettlement()!=null && getNonDeliverableSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementProvision.SettlementProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementProvision.SettlementProvisionBuilder o = (SettlementProvision.SettlementProvisionBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getNonDeliverableSettlement(), o.getNonDeliverableSettlement(), this::setNonDeliverableSettlement);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementProvision _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(nonDeliverableSettlement, _that.getNonDeliverableSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (nonDeliverableSettlement != null ? nonDeliverableSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementProvisionBuilder {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"nonDeliverableSettlement=" + this.nonDeliverableSettlement +
			'}';
		}
	}
}
