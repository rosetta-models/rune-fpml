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
import fpml.confirmation.FxAccrualSettlementPeriod;
import fpml.confirmation.FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder;
import fpml.confirmation.FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilderImpl;
import fpml.confirmation.FxAccrualSettlementPeriod.FxAccrualSettlementPeriodImpl;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import fpml.confirmation.FxSettlementPeriodBarrier;
import fpml.confirmation.SettlementPeriod;
import fpml.confirmation.SettlementPeriod.SettlementPeriodBuilder;
import fpml.confirmation.SettlementPeriod.SettlementPeriodBuilderImpl;
import fpml.confirmation.SettlementPeriod.SettlementPeriodImpl;
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.meta.FxAccrualSettlementPeriodMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualSettlementPeriod", builder=FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilderImpl.class, version="${project.version}")
public interface FxAccrualSettlementPeriod extends SettlementPeriod {

	FxAccrualSettlementPeriodMeta metaData = new FxAccrualSettlementPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Payoff Region within the settlement period to link strike with the relevant payoff components.
	 */
	List<? extends FxAccrualSettlementPeriodPayoff> getPayoff();
	/**
	 * Accrual factor for the settlement period.
	 */
	BigDecimal getAccrualFactor();
	/**
	 * The trigger rate of the Global Knockout Barrier for the settlement period.
	 */
	FxSettlementPeriodBarrier getBarrier();
	/**
	 * Actual fixing dates within the fixing period.
	 */
	SettlementPeriodFixingDates getAccrualFixingDates();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriod build();
	
	FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder toBuilder();
	
	static FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder() {
		return new FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualSettlementPeriod> getType() {
		return FxAccrualSettlementPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processRosetta(path.newSubPath("payoff"), processor, FxAccrualSettlementPeriodPayoff.class, getPayoff());
		processor.processBasic(path.newSubPath("accrualFactor"), BigDecimal.class, getAccrualFactor(), this);
		processRosetta(path.newSubPath("barrier"), processor, FxSettlementPeriodBarrier.class, getBarrier());
		processRosetta(path.newSubPath("accrualFixingDates"), processor, SettlementPeriodFixingDates.class, getAccrualFixingDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodBuilder extends FxAccrualSettlementPeriod, SettlementPeriod.SettlementPeriodBuilder {
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder getOrCreatePayoff(int _index);
		List<? extends FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder> getPayoff();
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getOrCreateBarrier();
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getBarrier();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAccrualFixingDates();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAccrualFixingDates();
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setExpiryDate(Date expiryDate);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setSettlementDate(Date settlementDate);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff payoff0);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff payoff1, int _idx);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoff2);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoff3);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFactor(BigDecimal accrualFactor);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setBarrier(FxSettlementPeriodBarrier barrier);
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFixingDates(SettlementPeriodFixingDates accrualFixingDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processRosetta(path.newSubPath("payoff"), processor, FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder.class, getPayoff());
			processor.processBasic(path.newSubPath("accrualFactor"), BigDecimal.class, getAccrualFactor(), this);
			processRosetta(path.newSubPath("barrier"), processor, FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("accrualFixingDates"), processor, SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder.class, getAccrualFixingDates());
		}
		

		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriod  ***********************/
	class FxAccrualSettlementPeriodImpl extends SettlementPeriod.SettlementPeriodImpl implements FxAccrualSettlementPeriod {
		private final List<? extends FxAccrualSettlementPeriodPayoff> payoff;
		private final BigDecimal accrualFactor;
		private final FxSettlementPeriodBarrier barrier;
		private final SettlementPeriodFixingDates accrualFixingDates;
		
		protected FxAccrualSettlementPeriodImpl(FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder) {
			super(builder);
			this.payoff = ofNullable(builder.getPayoff()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accrualFactor = builder.getAccrualFactor();
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.accrualFixingDates = ofNullable(builder.getAccrualFixingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payoff")
		public List<? extends FxAccrualSettlementPeriodPayoff> getPayoff() {
			return payoff;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		public BigDecimal getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public FxSettlementPeriodBarrier getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("accrualFixingDates")
		public SettlementPeriodFixingDates getAccrualFixingDates() {
			return accrualFixingDates;
		}
		
		@Override
		public FxAccrualSettlementPeriod build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder toBuilder() {
			FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayoff()).ifPresent(builder::setPayoff);
			ofNullable(getAccrualFactor()).ifPresent(builder::setAccrualFactor);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getAccrualFixingDates()).ifPresent(builder::setAccrualFixingDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualSettlementPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(accrualFixingDates, _that.getAccrualFixingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (accrualFixingDates != null ? accrualFixingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriod {" +
				"payoff=" + this.payoff + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"barrier=" + this.barrier + ", " +
				"accrualFixingDates=" + this.accrualFixingDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriod  ***********************/
	class FxAccrualSettlementPeriodBuilderImpl extends SettlementPeriod.SettlementPeriodBuilderImpl  implements FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder {
	
		protected List<FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder> payoff = new ArrayList<>();
		protected BigDecimal accrualFactor;
		protected FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder barrier;
		protected SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder accrualFixingDates;
	
		public FxAccrualSettlementPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payoff")
		public List<? extends FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder> getPayoff() {
			return payoff;
		}
		
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder getOrCreatePayoff(int _index) {
		
			if (payoff==null) {
				this.payoff = new ArrayList<>();
			}
			FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder result;
			return getIndex(payoff, _index, () -> {
						FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder newPayoff = FxAccrualSettlementPeriodPayoff.builder();
						return newPayoff;
					});
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		public BigDecimal getAccrualFactor() {
			return accrualFactor;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getOrCreateBarrier() {
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = FxSettlementPeriodBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualFixingDates")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAccrualFixingDates() {
			return accrualFixingDates;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAccrualFixingDates() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder result;
			if (accrualFixingDates!=null) {
				result = accrualFixingDates;
			}
			else {
				result = accrualFixingDates = SettlementPeriodFixingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount;
			return this;
		}
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff payoff) {
			if (payoff!=null) this.payoff.add(payoff.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(FxAccrualSettlementPeriodPayoff payoff, int _idx) {
			getIndex(this.payoff, _idx, () -> payoff.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder addPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoffs) {
			if (payoffs != null) {
				for (FxAccrualSettlementPeriodPayoff toAdd : payoffs) {
					this.payoff.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("payoff")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setPayoff(List<? extends FxAccrualSettlementPeriodPayoff> payoffs) {
			if (payoffs == null)  {
				this.payoff = new ArrayList<>();
			}
			else {
				this.payoff = payoffs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("accrualFactor")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFactor(BigDecimal accrualFactor) {
			this.accrualFactor = accrualFactor==null?null:accrualFactor;
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setBarrier(FxSettlementPeriodBarrier barrier) {
			this.barrier = barrier==null?null:barrier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accrualFixingDates")
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder setAccrualFixingDates(SettlementPeriodFixingDates accrualFixingDates) {
			this.accrualFixingDates = accrualFixingDates==null?null:accrualFixingDates.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriod build() {
			return new FxAccrualSettlementPeriod.FxAccrualSettlementPeriodImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder prune() {
			super.prune();
			payoff = payoff.stream().filter(b->b!=null).<FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (accrualFixingDates!=null && !accrualFixingDates.prune().hasData()) accrualFixingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayoff()!=null && getPayoff().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccrualFactor()!=null) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getAccrualFixingDates()!=null && getAccrualFixingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder o = (FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder) other;
			
			merger.mergeRosetta(getPayoff(), o.getPayoff(), this::getOrCreatePayoff);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getAccrualFixingDates(), o.getAccrualFixingDates(), this::setAccrualFixingDates);
			
			merger.mergeBasic(getAccrualFactor(), o.getAccrualFactor(), this::setAccrualFactor);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualSettlementPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(accrualFactor, _that.getAccrualFactor())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(accrualFixingDates, _that.getAccrualFixingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (accrualFactor != null ? accrualFactor.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (accrualFixingDates != null ? accrualFixingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodBuilder {" +
				"payoff=" + this.payoff + ", " +
				"accrualFactor=" + this.accrualFactor + ", " +
				"barrier=" + this.barrier + ", " +
				"accrualFixingDates=" + this.accrualFixingDates +
			'}' + " " + super.toString();
		}
	}
}
