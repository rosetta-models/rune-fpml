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
import fpml.confirmation.FixedRecoveryModel;
import fpml.confirmation.FixedRecoveryModel.FixedRecoveryModelBuilder;
import fpml.confirmation.FixedRecoveryModel.FixedRecoveryModelBuilderImpl;
import fpml.confirmation.FixedRecoveryModel.FixedRecoveryModelImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.FixedRecoveryModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FixedRecoveryModel", builder=FixedRecoveryModel.FixedRecoveryModelBuilderImpl.class, version="${project.version}")
public interface FixedRecoveryModel extends RosettaModelObject {

	FixedRecoveryModelMeta metaData = new FixedRecoveryModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
	 */
	Money getCashSettlementAmount();
	/**
	 * Used for fixed recovery, specifies the recovery level, determined at contract inception, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
	 */
	BigDecimal getRecoveryFactor();

	/*********************** Build Methods  ***********************/
	FixedRecoveryModel build();
	
	FixedRecoveryModel.FixedRecoveryModelBuilder toBuilder();
	
	static FixedRecoveryModel.FixedRecoveryModelBuilder builder() {
		return new FixedRecoveryModel.FixedRecoveryModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRecoveryModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedRecoveryModel> getType() {
		return FixedRecoveryModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementAmount"), processor, Money.class, getCashSettlementAmount());
		processor.processBasic(path.newSubPath("recoveryFactor"), BigDecimal.class, getRecoveryFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRecoveryModelBuilder extends FixedRecoveryModel, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCashSettlementAmount();
		Money.MoneyBuilder getCashSettlementAmount();
		FixedRecoveryModel.FixedRecoveryModelBuilder setCashSettlementAmount(Money cashSettlementAmount);
		FixedRecoveryModel.FixedRecoveryModelBuilder setRecoveryFactor(BigDecimal recoveryFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementAmount"), processor, Money.MoneyBuilder.class, getCashSettlementAmount());
			processor.processBasic(path.newSubPath("recoveryFactor"), BigDecimal.class, getRecoveryFactor(), this);
		}
		

		FixedRecoveryModel.FixedRecoveryModelBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRecoveryModel  ***********************/
	class FixedRecoveryModelImpl implements FixedRecoveryModel {
		private final Money cashSettlementAmount;
		private final BigDecimal recoveryFactor;
		
		protected FixedRecoveryModelImpl(FixedRecoveryModel.FixedRecoveryModelBuilder builder) {
			this.cashSettlementAmount = ofNullable(builder.getCashSettlementAmount()).map(f->f.build()).orElse(null);
			this.recoveryFactor = builder.getRecoveryFactor();
		}
		
		@Override
		@RosettaAttribute("cashSettlementAmount")
		public Money getCashSettlementAmount() {
			return cashSettlementAmount;
		}
		
		@Override
		@RosettaAttribute("recoveryFactor")
		public BigDecimal getRecoveryFactor() {
			return recoveryFactor;
		}
		
		@Override
		public FixedRecoveryModel build() {
			return this;
		}
		
		@Override
		public FixedRecoveryModel.FixedRecoveryModelBuilder toBuilder() {
			FixedRecoveryModel.FixedRecoveryModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRecoveryModel.FixedRecoveryModelBuilder builder) {
			ofNullable(getCashSettlementAmount()).ifPresent(builder::setCashSettlementAmount);
			ofNullable(getRecoveryFactor()).ifPresent(builder::setRecoveryFactor);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRecoveryModel _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementAmount, _that.getCashSettlementAmount())) return false;
			if (!Objects.equals(recoveryFactor, _that.getRecoveryFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementAmount != null ? cashSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (recoveryFactor != null ? recoveryFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRecoveryModel {" +
				"cashSettlementAmount=" + this.cashSettlementAmount + ", " +
				"recoveryFactor=" + this.recoveryFactor +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedRecoveryModel  ***********************/
	class FixedRecoveryModelBuilderImpl implements FixedRecoveryModel.FixedRecoveryModelBuilder {
	
		protected Money.MoneyBuilder cashSettlementAmount;
		protected BigDecimal recoveryFactor;
	
		public FixedRecoveryModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashSettlementAmount")
		public Money.MoneyBuilder getCashSettlementAmount() {
			return cashSettlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashSettlementAmount() {
			Money.MoneyBuilder result;
			if (cashSettlementAmount!=null) {
				result = cashSettlementAmount;
			}
			else {
				result = cashSettlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("recoveryFactor")
		public BigDecimal getRecoveryFactor() {
			return recoveryFactor;
		}
		
		@Override
		@RosettaAttribute("cashSettlementAmount")
		public FixedRecoveryModel.FixedRecoveryModelBuilder setCashSettlementAmount(Money cashSettlementAmount) {
			this.cashSettlementAmount = cashSettlementAmount==null?null:cashSettlementAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("recoveryFactor")
		public FixedRecoveryModel.FixedRecoveryModelBuilder setRecoveryFactor(BigDecimal recoveryFactor) {
			this.recoveryFactor = recoveryFactor==null?null:recoveryFactor;
			return this;
		}
		
		@Override
		public FixedRecoveryModel build() {
			return new FixedRecoveryModel.FixedRecoveryModelImpl(this);
		}
		
		@Override
		public FixedRecoveryModel.FixedRecoveryModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRecoveryModel.FixedRecoveryModelBuilder prune() {
			if (cashSettlementAmount!=null && !cashSettlementAmount.prune().hasData()) cashSettlementAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementAmount()!=null && getCashSettlementAmount().hasData()) return true;
			if (getRecoveryFactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRecoveryModel.FixedRecoveryModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedRecoveryModel.FixedRecoveryModelBuilder o = (FixedRecoveryModel.FixedRecoveryModelBuilder) other;
			
			merger.mergeRosetta(getCashSettlementAmount(), o.getCashSettlementAmount(), this::setCashSettlementAmount);
			
			merger.mergeBasic(getRecoveryFactor(), o.getRecoveryFactor(), this::setRecoveryFactor);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRecoveryModel _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementAmount, _that.getCashSettlementAmount())) return false;
			if (!Objects.equals(recoveryFactor, _that.getRecoveryFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementAmount != null ? cashSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (recoveryFactor != null ? recoveryFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRecoveryModelBuilder {" +
				"cashSettlementAmount=" + this.cashSettlementAmount + ", " +
				"recoveryFactor=" + this.recoveryFactor +
			'}';
		}
	}
}
