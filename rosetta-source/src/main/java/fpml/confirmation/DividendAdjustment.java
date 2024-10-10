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
import fpml.confirmation.DividendAdjustment;
import fpml.confirmation.DividendAdjustment.DividendAdjustmentBuilder;
import fpml.confirmation.DividendAdjustment.DividendAdjustmentBuilderImpl;
import fpml.confirmation.DividendAdjustment.DividendAdjustmentImpl;
import fpml.confirmation.DividendPeriodDividend;
import fpml.confirmation.meta.DividendAdjustmentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Container for Dividend Adjustment Periods, which are used to calculate the Deviation between Expected Dividend and Actual Dividend in that Period.
 * @version ${project.version}
 */
@RosettaDataType(value="DividendAdjustment", builder=DividendAdjustment.DividendAdjustmentBuilderImpl.class, version="${project.version}")
public interface DividendAdjustment extends RosettaModelObject {

	DividendAdjustmentMeta metaData = new DividendAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A single Dividend Adjustment Period.
	 */
	List<? extends DividendPeriodDividend> getDividendPeriod();

	/*********************** Build Methods  ***********************/
	DividendAdjustment build();
	
	DividendAdjustment.DividendAdjustmentBuilder toBuilder();
	
	static DividendAdjustment.DividendAdjustmentBuilder builder() {
		return new DividendAdjustment.DividendAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendAdjustment> getType() {
		return DividendAdjustment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dividendPeriod"), processor, DividendPeriodDividend.class, getDividendPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendAdjustmentBuilder extends DividendAdjustment, RosettaModelObjectBuilder {
		DividendPeriodDividend.DividendPeriodDividendBuilder getOrCreateDividendPeriod(int _index);
		List<? extends DividendPeriodDividend.DividendPeriodDividendBuilder> getDividendPeriod();
		DividendAdjustment.DividendAdjustmentBuilder addDividendPeriod(DividendPeriodDividend dividendPeriod0);
		DividendAdjustment.DividendAdjustmentBuilder addDividendPeriod(DividendPeriodDividend dividendPeriod1, int _idx);
		DividendAdjustment.DividendAdjustmentBuilder addDividendPeriod(List<? extends DividendPeriodDividend> dividendPeriod2);
		DividendAdjustment.DividendAdjustmentBuilder setDividendPeriod(List<? extends DividendPeriodDividend> dividendPeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dividendPeriod"), processor, DividendPeriodDividend.DividendPeriodDividendBuilder.class, getDividendPeriod());
		}
		

		DividendAdjustment.DividendAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of DividendAdjustment  ***********************/
	class DividendAdjustmentImpl implements DividendAdjustment {
		private final List<? extends DividendPeriodDividend> dividendPeriod;
		
		protected DividendAdjustmentImpl(DividendAdjustment.DividendAdjustmentBuilder builder) {
			this.dividendPeriod = ofNullable(builder.getDividendPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		public List<? extends DividendPeriodDividend> getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		public DividendAdjustment build() {
			return this;
		}
		
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder toBuilder() {
			DividendAdjustment.DividendAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendAdjustment.DividendAdjustmentBuilder builder) {
			ofNullable(getDividendPeriod()).ifPresent(builder::setDividendPeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendAdjustment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dividendPeriod, _that.getDividendPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendAdjustment {" +
				"dividendPeriod=" + this.dividendPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendAdjustment  ***********************/
	class DividendAdjustmentBuilderImpl implements DividendAdjustment.DividendAdjustmentBuilder {
	
		protected List<DividendPeriodDividend.DividendPeriodDividendBuilder> dividendPeriod = new ArrayList<>();
	
		public DividendAdjustmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendPeriod")
		public List<? extends DividendPeriodDividend.DividendPeriodDividendBuilder> getDividendPeriod() {
			return dividendPeriod;
		}
		
		public DividendPeriodDividend.DividendPeriodDividendBuilder getOrCreateDividendPeriod(int _index) {
		
			if (dividendPeriod==null) {
				this.dividendPeriod = new ArrayList<>();
			}
			DividendPeriodDividend.DividendPeriodDividendBuilder result;
			return getIndex(dividendPeriod, _index, () -> {
						DividendPeriodDividend.DividendPeriodDividendBuilder newDividendPeriod = DividendPeriodDividend.builder();
						return newDividendPeriod;
					});
		}
		
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder addDividendPeriod(DividendPeriodDividend dividendPeriod) {
			if (dividendPeriod!=null) this.dividendPeriod.add(dividendPeriod.toBuilder());
			return this;
		}
		
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder addDividendPeriod(DividendPeriodDividend dividendPeriod, int _idx) {
			getIndex(this.dividendPeriod, _idx, () -> dividendPeriod.toBuilder());
			return this;
		}
		@Override 
		public DividendAdjustment.DividendAdjustmentBuilder addDividendPeriod(List<? extends DividendPeriodDividend> dividendPeriods) {
			if (dividendPeriods != null) {
				for (DividendPeriodDividend toAdd : dividendPeriods) {
					this.dividendPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("dividendPeriod")
		public DividendAdjustment.DividendAdjustmentBuilder setDividendPeriod(List<? extends DividendPeriodDividend> dividendPeriods) {
			if (dividendPeriods == null)  {
				this.dividendPeriod = new ArrayList<>();
			}
			else {
				this.dividendPeriod = dividendPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DividendAdjustment build() {
			return new DividendAdjustment.DividendAdjustmentImpl(this);
		}
		
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder prune() {
			dividendPeriod = dividendPeriod.stream().filter(b->b!=null).<DividendPeriodDividend.DividendPeriodDividendBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPeriod()!=null && getDividendPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendAdjustment.DividendAdjustmentBuilder o = (DividendAdjustment.DividendAdjustmentBuilder) other;
			
			merger.mergeRosetta(getDividendPeriod(), o.getDividendPeriod(), this::getOrCreateDividendPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendAdjustment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dividendPeriod, _that.getDividendPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendAdjustmentBuilder {" +
				"dividendPeriod=" + this.dividendPeriod +
			'}';
		}
	}
}
