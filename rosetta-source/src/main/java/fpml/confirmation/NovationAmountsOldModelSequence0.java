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
import fpml.confirmation.Money;
import fpml.confirmation.NovationAmountsOldModelSequence0;
import fpml.confirmation.NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder;
import fpml.confirmation.NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0BuilderImpl;
import fpml.confirmation.NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Impl;
import fpml.confirmation.meta.NovationAmountsOldModelSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NovationAmountsOldModelSequence0", builder=NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0BuilderImpl.class, version="${project.version}")
public interface NovationAmountsOldModelSequence0 extends RosettaModelObject {

	NovationAmountsOldModelSequence0Meta metaData = new NovationAmountsOldModelSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount which represents the portion of the Old Contract being novated.
	 */
	List<? extends Money> getNovatedAmount();
	/**
	 * The amount which represents the portion of the Old Contract not being novated.
	 */
	List<? extends Money> getRemainingAmount();

	/*********************** Build Methods  ***********************/
	NovationAmountsOldModelSequence0 build();
	
	NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder toBuilder();
	
	static NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder builder() {
		return new NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationAmountsOldModelSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationAmountsOldModelSequence0> getType() {
		return NovationAmountsOldModelSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("novatedAmount"), processor, Money.class, getNovatedAmount());
		processRosetta(path.newSubPath("remainingAmount"), processor, Money.class, getRemainingAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationAmountsOldModelSequence0Builder extends NovationAmountsOldModelSequence0, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateNovatedAmount(int _index);
		List<? extends Money.MoneyBuilder> getNovatedAmount();
		Money.MoneyBuilder getOrCreateRemainingAmount(int _index);
		List<? extends Money.MoneyBuilder> getRemainingAmount();
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addNovatedAmount(Money novatedAmount0);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addNovatedAmount(Money novatedAmount1, int _idx);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addNovatedAmount(List<? extends Money> novatedAmount2);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder setNovatedAmount(List<? extends Money> novatedAmount3);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addRemainingAmount(Money remainingAmount0);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addRemainingAmount(Money remainingAmount1, int _idx);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addRemainingAmount(List<? extends Money> remainingAmount2);
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder setRemainingAmount(List<? extends Money> remainingAmount3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("novatedAmount"), processor, Money.MoneyBuilder.class, getNovatedAmount());
			processRosetta(path.newSubPath("remainingAmount"), processor, Money.MoneyBuilder.class, getRemainingAmount());
		}
		

		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder prune();
	}

	/*********************** Immutable Implementation of NovationAmountsOldModelSequence0  ***********************/
	class NovationAmountsOldModelSequence0Impl implements NovationAmountsOldModelSequence0 {
		private final List<? extends Money> novatedAmount;
		private final List<? extends Money> remainingAmount;
		
		protected NovationAmountsOldModelSequence0Impl(NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder builder) {
			this.novatedAmount = ofNullable(builder.getNovatedAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.remainingAmount = ofNullable(builder.getRemainingAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("novatedAmount")
		public List<? extends Money> getNovatedAmount() {
			return novatedAmount;
		}
		
		@Override
		@RosettaAttribute("remainingAmount")
		public List<? extends Money> getRemainingAmount() {
			return remainingAmount;
		}
		
		@Override
		public NovationAmountsOldModelSequence0 build() {
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder toBuilder() {
			NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder builder) {
			ofNullable(getNovatedAmount()).ifPresent(builder::setNovatedAmount);
			ofNullable(getRemainingAmount()).ifPresent(builder::setRemainingAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModelSequence0 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(novatedAmount, _that.getNovatedAmount())) return false;
			if (!ListEquals.listEquals(remainingAmount, _that.getRemainingAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novatedAmount != null ? novatedAmount.hashCode() : 0);
			_result = 31 * _result + (remainingAmount != null ? remainingAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelSequence0 {" +
				"novatedAmount=" + this.novatedAmount + ", " +
				"remainingAmount=" + this.remainingAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationAmountsOldModelSequence0  ***********************/
	class NovationAmountsOldModelSequence0BuilderImpl implements NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder {
	
		protected List<Money.MoneyBuilder> novatedAmount = new ArrayList<>();
		protected List<Money.MoneyBuilder> remainingAmount = new ArrayList<>();
	
		public NovationAmountsOldModelSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("novatedAmount")
		public List<? extends Money.MoneyBuilder> getNovatedAmount() {
			return novatedAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNovatedAmount(int _index) {
		
			if (novatedAmount==null) {
				this.novatedAmount = new ArrayList<>();
			}
			Money.MoneyBuilder result;
			return getIndex(novatedAmount, _index, () -> {
						Money.MoneyBuilder newNovatedAmount = Money.builder();
						return newNovatedAmount;
					});
		}
		
		@Override
		@RosettaAttribute("remainingAmount")
		public List<? extends Money.MoneyBuilder> getRemainingAmount() {
			return remainingAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateRemainingAmount(int _index) {
		
			if (remainingAmount==null) {
				this.remainingAmount = new ArrayList<>();
			}
			Money.MoneyBuilder result;
			return getIndex(remainingAmount, _index, () -> {
						Money.MoneyBuilder newRemainingAmount = Money.builder();
						return newRemainingAmount;
					});
		}
		
		@Override
		@RosettaAttribute("novatedAmount")
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addNovatedAmount(Money novatedAmount) {
			if (novatedAmount!=null) this.novatedAmount.add(novatedAmount.toBuilder());
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addNovatedAmount(Money novatedAmount, int _idx) {
			getIndex(this.novatedAmount, _idx, () -> novatedAmount.toBuilder());
			return this;
		}
		@Override 
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addNovatedAmount(List<? extends Money> novatedAmounts) {
			if (novatedAmounts != null) {
				for (Money toAdd : novatedAmounts) {
					this.novatedAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder setNovatedAmount(List<? extends Money> novatedAmounts) {
			if (novatedAmounts == null)  {
				this.novatedAmount = new ArrayList<>();
			}
			else {
				this.novatedAmount = novatedAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("remainingAmount")
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addRemainingAmount(Money remainingAmount) {
			if (remainingAmount!=null) this.remainingAmount.add(remainingAmount.toBuilder());
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addRemainingAmount(Money remainingAmount, int _idx) {
			getIndex(this.remainingAmount, _idx, () -> remainingAmount.toBuilder());
			return this;
		}
		@Override 
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder addRemainingAmount(List<? extends Money> remainingAmounts) {
			if (remainingAmounts != null) {
				for (Money toAdd : remainingAmounts) {
					this.remainingAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder setRemainingAmount(List<? extends Money> remainingAmounts) {
			if (remainingAmounts == null)  {
				this.remainingAmount = new ArrayList<>();
			}
			else {
				this.remainingAmount = remainingAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public NovationAmountsOldModelSequence0 build() {
			return new NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Impl(this);
		}
		
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder prune() {
			novatedAmount = novatedAmount.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			remainingAmount = remainingAmount.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNovatedAmount()!=null && getNovatedAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRemainingAmount()!=null && getRemainingAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder o = (NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder) other;
			
			merger.mergeRosetta(getNovatedAmount(), o.getNovatedAmount(), this::getOrCreateNovatedAmount);
			merger.mergeRosetta(getRemainingAmount(), o.getRemainingAmount(), this::getOrCreateRemainingAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModelSequence0 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(novatedAmount, _that.getNovatedAmount())) return false;
			if (!ListEquals.listEquals(remainingAmount, _that.getRemainingAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novatedAmount != null ? novatedAmount.hashCode() : 0);
			_result = 31 * _result + (remainingAmount != null ? remainingAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelSequence0Builder {" +
				"novatedAmount=" + this.novatedAmount + ", " +
				"remainingAmount=" + this.remainingAmount +
			'}';
		}
	}
}
