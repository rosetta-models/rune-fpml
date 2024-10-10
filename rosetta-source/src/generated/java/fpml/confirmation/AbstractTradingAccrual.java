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
import fpml.confirmation.AbstractTradingAccrual;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualBuilder;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualImpl;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.AbstractTradingAccrualMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An underlying structure that details the elements that affect the calculation of a trade-related accrual.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractTradingAccrual", builder=AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl.class, version="${project.version}")
public interface AbstractTradingAccrual extends RosettaModelObject {

	AbstractTradingAccrualMeta metaData = new AbstractTradingAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The total accrual amount.
	 */
	NonNegativeMoney getAmount();
	/**
	 * One or more accrual periods which reflect the constituent portions of the accrual amount.
	 */
	List<? extends AccrualPeriod> getAccrualPeriod();

	/*********************** Build Methods  ***********************/
	AbstractTradingAccrual build();
	
	AbstractTradingAccrual.AbstractTradingAccrualBuilder toBuilder();
	
	static AbstractTradingAccrual.AbstractTradingAccrualBuilder builder() {
		return new AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractTradingAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractTradingAccrual> getType() {
		return AbstractTradingAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractTradingAccrualBuilder extends AbstractTradingAccrual, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualPeriod(int _index);
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualPeriod();
		AbstractTradingAccrual.AbstractTradingAccrualBuilder setAmount(NonNegativeMoney amount);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod0);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod1, int _idx);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod2);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
		}
		

		AbstractTradingAccrual.AbstractTradingAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractTradingAccrual  ***********************/
	class AbstractTradingAccrualImpl implements AbstractTradingAccrual {
		private final NonNegativeMoney amount;
		private final List<? extends AccrualPeriod> accrualPeriod;
		
		protected AbstractTradingAccrualImpl(AbstractTradingAccrual.AbstractTradingAccrualBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrualPeriod = ofNullable(builder.getAccrualPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("accrualPeriod")
		public List<? extends AccrualPeriod> getAccrualPeriod() {
			return accrualPeriod;
		}
		
		@Override
		public AbstractTradingAccrual build() {
			return this;
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder toBuilder() {
			AbstractTradingAccrual.AbstractTradingAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractTradingAccrual.AbstractTradingAccrualBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualPeriod()).ifPresent(builder::setAccrualPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractTradingAccrual _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualPeriod, _that.getAccrualPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualPeriod != null ? accrualPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractTradingAccrual {" +
				"amount=" + this.amount + ", " +
				"accrualPeriod=" + this.accrualPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractTradingAccrual  ***********************/
	class AbstractTradingAccrualBuilderImpl implements AbstractTradingAccrual.AbstractTradingAccrualBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualPeriod = new ArrayList<>();
	
		public AbstractTradingAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualPeriod")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualPeriod() {
			return accrualPeriod;
		}
		
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualPeriod(int _index) {
		
			if (accrualPeriod==null) {
				this.accrualPeriod = new ArrayList<>();
			}
			AccrualPeriod.AccrualPeriodBuilder result;
			return getIndex(accrualPeriod, _index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newAccrualPeriod = AccrualPeriod.builder();
						return newAccrualPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("amount")
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod) {
			if (accrualPeriod!=null) this.accrualPeriod.add(accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int _idx) {
			getIndex(this.accrualPeriod, _idx, () -> accrualPeriod.toBuilder());
			return this;
		}
		@Override 
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualPeriod")
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null)  {
				this.accrualPeriod = new ArrayList<>();
			}
			else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractTradingAccrual build() {
			return new AbstractTradingAccrual.AbstractTradingAccrualImpl(this);
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualPeriod = accrualPeriod.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualPeriod()!=null && getAccrualPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractTradingAccrual.AbstractTradingAccrualBuilder o = (AbstractTradingAccrual.AbstractTradingAccrualBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrualPeriod(), o.getAccrualPeriod(), this::getOrCreateAccrualPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractTradingAccrual _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualPeriod, _that.getAccrualPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualPeriod != null ? accrualPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractTradingAccrualBuilder {" +
				"amount=" + this.amount + ", " +
				"accrualPeriod=" + this.accrualPeriod +
			'}';
		}
	}
}
