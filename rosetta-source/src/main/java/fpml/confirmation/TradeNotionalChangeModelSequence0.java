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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TradeNotionalChangeModelSequence0;
import fpml.confirmation.TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder;
import fpml.confirmation.TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0BuilderImpl;
import fpml.confirmation.TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Impl;
import fpml.confirmation.meta.TradeNotionalChangeModelSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNotionalChangeModelSequence0", builder=TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0BuilderImpl.class, version="${project.version}")
public interface TradeNotionalChangeModelSequence0 extends RosettaModelObject {

	TradeNotionalChangeModelSequence0Meta metaData = new TradeNotionalChangeModelSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fixed amount by which the Notional Amount changes. The direction of the change (increase or decrease) is specified by the event type (Termination =&amp;gt; reduction, Increase =&amp;gt; greater.)
	 */
	List<? extends NonNegativeMoney> getChangeInNotionalAmount();
	/**
	 * Specifies the Notional amount after the Change
	 */
	List<? extends NonNegativeMoney> getOutstandingNotionalAmount();

	/*********************** Build Methods  ***********************/
	TradeNotionalChangeModelSequence0 build();
	
	TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder toBuilder();
	
	static TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder builder() {
		return new TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNotionalChangeModelSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNotionalChangeModelSequence0> getType() {
		return TradeNotionalChangeModelSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.class, getChangeInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.class, getOutstandingNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNotionalChangeModelSequence0Builder extends TradeNotionalChangeModelSequence0, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount(int _index);
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getChangeInNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount(int _index);
		List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getOutstandingNotionalAmount();
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount0);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount1, int _idx);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmount2);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder setChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmount3);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount0);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount1, int _idx);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmount2);
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder setOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmount3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getChangeInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getOutstandingNotionalAmount());
		}
		

		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder prune();
	}

	/*********************** Immutable Implementation of TradeNotionalChangeModelSequence0  ***********************/
	class TradeNotionalChangeModelSequence0Impl implements TradeNotionalChangeModelSequence0 {
		private final List<? extends NonNegativeMoney> changeInNotionalAmount;
		private final List<? extends NonNegativeMoney> outstandingNotionalAmount;
		
		protected TradeNotionalChangeModelSequence0Impl(TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder builder) {
			this.changeInNotionalAmount = ofNullable(builder.getChangeInNotionalAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		public List<? extends NonNegativeMoney> getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public List<? extends NonNegativeMoney> getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public TradeNotionalChangeModelSequence0 build() {
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder toBuilder() {
			TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder builder) {
			ofNullable(getChangeInNotionalAmount()).ifPresent(builder::setChangeInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModelSequence0 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!ListEquals.listEquals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelSequence0 {" +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNotionalChangeModelSequence0  ***********************/
	class TradeNotionalChangeModelSequence0BuilderImpl implements TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder {
	
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> changeInNotionalAmount = new ArrayList<>();
		protected List<NonNegativeMoney.NonNegativeMoneyBuilder> outstandingNotionalAmount = new ArrayList<>();
	
		public TradeNotionalChangeModelSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount(int _index) {
		
			if (changeInNotionalAmount==null) {
				this.changeInNotionalAmount = new ArrayList<>();
			}
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			return getIndex(changeInNotionalAmount, _index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newChangeInNotionalAmount = NonNegativeMoney.builder();
						return newChangeInNotionalAmount;
					});
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public List<? extends NonNegativeMoney.NonNegativeMoneyBuilder> getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount(int _index) {
		
			if (outstandingNotionalAmount==null) {
				this.outstandingNotionalAmount = new ArrayList<>();
			}
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			return getIndex(outstandingNotionalAmount, _index, () -> {
						NonNegativeMoney.NonNegativeMoneyBuilder newOutstandingNotionalAmount = NonNegativeMoney.builder();
						return newOutstandingNotionalAmount;
					});
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount) {
			if (changeInNotionalAmount!=null) this.changeInNotionalAmount.add(changeInNotionalAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount, int _idx) {
			getIndex(this.changeInNotionalAmount, _idx, () -> changeInNotionalAmount.toBuilder());
			return this;
		}
		@Override 
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmounts) {
			if (changeInNotionalAmounts != null) {
				for (NonNegativeMoney toAdd : changeInNotionalAmounts) {
					this.changeInNotionalAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("changeInNotionalAmount")
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder setChangeInNotionalAmount(List<? extends NonNegativeMoney> changeInNotionalAmounts) {
			if (changeInNotionalAmounts == null)  {
				this.changeInNotionalAmount = new ArrayList<>();
			}
			else {
				this.changeInNotionalAmount = changeInNotionalAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount) {
			if (outstandingNotionalAmount!=null) this.outstandingNotionalAmount.add(outstandingNotionalAmount.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount, int _idx) {
			getIndex(this.outstandingNotionalAmount, _idx, () -> outstandingNotionalAmount.toBuilder());
			return this;
		}
		@Override 
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder addOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmounts) {
			if (outstandingNotionalAmounts != null) {
				for (NonNegativeMoney toAdd : outstandingNotionalAmounts) {
					this.outstandingNotionalAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("outstandingNotionalAmount")
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder setOutstandingNotionalAmount(List<? extends NonNegativeMoney> outstandingNotionalAmounts) {
			if (outstandingNotionalAmounts == null)  {
				this.outstandingNotionalAmount = new ArrayList<>();
			}
			else {
				this.outstandingNotionalAmount = outstandingNotionalAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TradeNotionalChangeModelSequence0 build() {
			return new TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Impl(this);
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder prune() {
			changeInNotionalAmount = changeInNotionalAmount.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			outstandingNotionalAmount = outstandingNotionalAmount.stream().filter(b->b!=null).<NonNegativeMoney.NonNegativeMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChangeInNotionalAmount()!=null && getChangeInNotionalAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder o = (TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder) other;
			
			merger.mergeRosetta(getChangeInNotionalAmount(), o.getChangeInNotionalAmount(), this::getOrCreateChangeInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::getOrCreateOutstandingNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModelSequence0 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!ListEquals.listEquals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelSequence0Builder {" +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}
}
