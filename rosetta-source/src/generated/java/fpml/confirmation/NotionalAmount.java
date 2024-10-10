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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilder;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyBuilderImpl;
import fpml.confirmation.NonNegativeMoney.NonNegativeMoneyImpl;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.NotionalAmount.NotionalAmountBuilder;
import fpml.confirmation.NotionalAmount.NotionalAmountBuilderImpl;
import fpml.confirmation.NotionalAmount.NotionalAmountImpl;
import fpml.confirmation.meta.NotionalAmountMeta;
import java.math.BigDecimal;


/**
 * A complex type to specify the notional amount.
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalAmount", builder=NotionalAmount.NotionalAmountBuilderImpl.class, version="${project.version}")
public interface NotionalAmount extends NonNegativeMoney {

	NotionalAmountMeta metaData = new NotionalAmountMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NotionalAmount build();
	
	NotionalAmount.NotionalAmountBuilder toBuilder();
	
	static NotionalAmount.NotionalAmountBuilder builder() {
		return new NotionalAmount.NotionalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotionalAmount> getType() {
		return NotionalAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmountBuilder extends NotionalAmount, NonNegativeMoney.NonNegativeMoneyBuilder {
		NotionalAmount.NotionalAmountBuilder setCurrency(Currency currency);
		NotionalAmount.NotionalAmountBuilder setId(String id);
		NotionalAmount.NotionalAmountBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		NotionalAmount.NotionalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalAmount  ***********************/
	class NotionalAmountImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements NotionalAmount {
		
		protected NotionalAmountImpl(NotionalAmount.NotionalAmountBuilder builder) {
			super(builder);
		}
		
		@Override
		public NotionalAmount build() {
			return this;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder toBuilder() {
			NotionalAmount.NotionalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmount.NotionalAmountBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmount {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NotionalAmount  ***********************/
	class NotionalAmountBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl  implements NotionalAmount.NotionalAmountBuilder {
	
	
		public NotionalAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public NotionalAmount.NotionalAmountBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public NotionalAmount.NotionalAmountBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public NotionalAmount.NotionalAmountBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		
		@Override
		public NotionalAmount build() {
			return new NotionalAmount.NotionalAmountImpl(this);
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount.NotionalAmountBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount.NotionalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NotionalAmount.NotionalAmountBuilder o = (NotionalAmount.NotionalAmountBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmountBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
