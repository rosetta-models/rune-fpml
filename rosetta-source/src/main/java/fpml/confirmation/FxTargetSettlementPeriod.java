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
import fpml.confirmation.FxSettlementPeriodBarrier;
import fpml.confirmation.FxTargetSettlementPeriod;
import fpml.confirmation.FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder;
import fpml.confirmation.FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilderImpl;
import fpml.confirmation.FxTargetSettlementPeriod.FxTargetSettlementPeriodImpl;
import fpml.confirmation.FxTargetSettlementPeriodPayoff;
import fpml.confirmation.SettlementPeriod;
import fpml.confirmation.SettlementPeriod.SettlementPeriodBuilder;
import fpml.confirmation.SettlementPeriod.SettlementPeriodBuilderImpl;
import fpml.confirmation.SettlementPeriod.SettlementPeriodImpl;
import fpml.confirmation.meta.FxTargetSettlementPeriodMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetSettlementPeriod", builder=FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilderImpl.class, version="${project.version}")
public interface FxTargetSettlementPeriod extends SettlementPeriod {

	FxTargetSettlementPeriodMeta metaData = new FxTargetSettlementPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Pivot for the settlement period. When pivot is present, at least two payoff elements must be present within the settlement period.
	 */
	BigDecimal getPivot();
	/**
	 * Payoff Region within the settlement period to link strike with the relevant payoff components.
	 */
	List<? extends FxTargetSettlementPeriodPayoff> getPayoff();
	/**
	 * The trigger rate of the barrier (Per Expiry or Global Knockout) for the settlement period.
	 */
	List<? extends FxSettlementPeriodBarrier> getBarrier();

	/*********************** Build Methods  ***********************/
	FxTargetSettlementPeriod build();
	
	FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder toBuilder();
	
	static FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder builder() {
		return new FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetSettlementPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetSettlementPeriod> getType() {
		return FxTargetSettlementPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processor.processBasic(path.newSubPath("pivot"), BigDecimal.class, getPivot(), this);
		processRosetta(path.newSubPath("payoff"), processor, FxTargetSettlementPeriodPayoff.class, getPayoff());
		processRosetta(path.newSubPath("barrier"), processor, FxSettlementPeriodBarrier.class, getBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetSettlementPeriodBuilder extends FxTargetSettlementPeriod, SettlementPeriod.SettlementPeriodBuilder {
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder getOrCreatePayoff(int _index);
		List<? extends FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder> getPayoff();
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getOrCreateBarrier(int _index);
		List<? extends FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder> getBarrier();
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setExpiryDate(Date expiryDate);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setSettlementDate(Date settlementDate);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setPivot(BigDecimal pivot);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addPayoff(FxTargetSettlementPeriodPayoff payoff0);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addPayoff(FxTargetSettlementPeriodPayoff payoff1, int _idx);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addPayoff(List<? extends FxTargetSettlementPeriodPayoff> payoff2);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setPayoff(List<? extends FxTargetSettlementPeriodPayoff> payoff3);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addBarrier(FxSettlementPeriodBarrier barrier0);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addBarrier(FxSettlementPeriodBarrier barrier1, int _idx);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addBarrier(List<? extends FxSettlementPeriodBarrier> barrier2);
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setBarrier(List<? extends FxSettlementPeriodBarrier> barrier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processor.processBasic(path.newSubPath("pivot"), BigDecimal.class, getPivot(), this);
			processRosetta(path.newSubPath("payoff"), processor, FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder.class, getPayoff());
			processRosetta(path.newSubPath("barrier"), processor, FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder.class, getBarrier());
		}
		

		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetSettlementPeriod  ***********************/
	class FxTargetSettlementPeriodImpl extends SettlementPeriod.SettlementPeriodImpl implements FxTargetSettlementPeriod {
		private final BigDecimal pivot;
		private final List<? extends FxTargetSettlementPeriodPayoff> payoff;
		private final List<? extends FxSettlementPeriodBarrier> barrier;
		
		protected FxTargetSettlementPeriodImpl(FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder builder) {
			super(builder);
			this.pivot = builder.getPivot();
			this.payoff = ofNullable(builder.getPayoff()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pivot")
		public BigDecimal getPivot() {
			return pivot;
		}
		
		@Override
		@RosettaAttribute("payoff")
		public List<? extends FxTargetSettlementPeriodPayoff> getPayoff() {
			return payoff;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxSettlementPeriodBarrier> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxTargetSettlementPeriod build() {
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder toBuilder() {
			FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPivot()).ifPresent(builder::setPivot);
			ofNullable(getPayoff()).ifPresent(builder::setPayoff);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetSettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(pivot, _that.getPivot())) return false;
			if (!ListEquals.listEquals(payoff, _that.getPayoff())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (pivot != null ? pivot.hashCode() : 0);
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetSettlementPeriod {" +
				"pivot=" + this.pivot + ", " +
				"payoff=" + this.payoff + ", " +
				"barrier=" + this.barrier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetSettlementPeriod  ***********************/
	class FxTargetSettlementPeriodBuilderImpl extends SettlementPeriod.SettlementPeriodBuilderImpl  implements FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder {
	
		protected BigDecimal pivot;
		protected List<FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder> payoff = new ArrayList<>();
		protected List<FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder> barrier = new ArrayList<>();
	
		public FxTargetSettlementPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pivot")
		public BigDecimal getPivot() {
			return pivot;
		}
		
		@Override
		@RosettaAttribute("payoff")
		public List<? extends FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder> getPayoff() {
			return payoff;
		}
		
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder getOrCreatePayoff(int _index) {
		
			if (payoff==null) {
				this.payoff = new ArrayList<>();
			}
			FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder result;
			return getIndex(payoff, _index, () -> {
						FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder newPayoff = FxTargetSettlementPeriodPayoff.builder();
						return newPayoff;
					});
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder getOrCreateBarrier(int _index) {
		
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder result;
			return getIndex(barrier, _index, () -> {
						FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder newBarrier = FxSettlementPeriodBarrier.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount;
			return this;
		}
		@Override
		@RosettaAttribute("pivot")
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setPivot(BigDecimal pivot) {
			this.pivot = pivot==null?null:pivot;
			return this;
		}
		@Override
		@RosettaAttribute("payoff")
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addPayoff(FxTargetSettlementPeriodPayoff payoff) {
			if (payoff!=null) this.payoff.add(payoff.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addPayoff(FxTargetSettlementPeriodPayoff payoff, int _idx) {
			getIndex(this.payoff, _idx, () -> payoff.toBuilder());
			return this;
		}
		@Override 
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addPayoff(List<? extends FxTargetSettlementPeriodPayoff> payoffs) {
			if (payoffs != null) {
				for (FxTargetSettlementPeriodPayoff toAdd : payoffs) {
					this.payoff.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setPayoff(List<? extends FxTargetSettlementPeriodPayoff> payoffs) {
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
		@RosettaAttribute("barrier")
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addBarrier(FxSettlementPeriodBarrier barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addBarrier(FxSettlementPeriodBarrier barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder addBarrier(List<? extends FxSettlementPeriodBarrier> barriers) {
			if (barriers != null) {
				for (FxSettlementPeriodBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder setBarrier(List<? extends FxSettlementPeriodBarrier> barriers) {
			if (barriers == null)  {
				this.barrier = new ArrayList<>();
			}
			else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxTargetSettlementPeriod build() {
			return new FxTargetSettlementPeriod.FxTargetSettlementPeriodImpl(this);
		}
		
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder prune() {
			super.prune();
			payoff = payoff.stream().filter(b->b!=null).<FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			barrier = barrier.stream().filter(b->b!=null).<FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPivot()!=null) return true;
			if (getPayoff()!=null && getPayoff().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder o = (FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder) other;
			
			merger.mergeRosetta(getPayoff(), o.getPayoff(), this::getOrCreatePayoff);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			
			merger.mergeBasic(getPivot(), o.getPivot(), this::setPivot);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetSettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(pivot, _that.getPivot())) return false;
			if (!ListEquals.listEquals(payoff, _that.getPayoff())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (pivot != null ? pivot.hashCode() : 0);
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetSettlementPeriodBuilder {" +
				"pivot=" + this.pivot + ", " +
				"payoff=" + this.payoff + ", " +
				"barrier=" + this.barrier +
			'}' + " " + super.toString();
		}
	}
}
