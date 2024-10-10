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
import fpml.confirmation.FxAccrualSettlementPeriod;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilderImpl;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleImpl;
import fpml.confirmation.meta.FxAccrualSettlementPeriodScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualSettlementPeriodSchedule", builder=FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilderImpl.class, version="${project.version}")
public interface FxAccrualSettlementPeriodSchedule extends RosettaModelObject {

	FxAccrualSettlementPeriodScheduleMeta metaData = new FxAccrualSettlementPeriodScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines each settlement period in the tabular/matrix representation of the product.
	 */
	List<? extends FxAccrualSettlementPeriod> getSettlementPeriod();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriodSchedule build();
	
	FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder toBuilder();
	
	static FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder() {
		return new FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriodSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualSettlementPeriodSchedule> getType() {
		return FxAccrualSettlementPeriodSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriod"), processor, FxAccrualSettlementPeriod.class, getSettlementPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodScheduleBuilder extends FxAccrualSettlementPeriodSchedule, RosettaModelObjectBuilder {
		FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder getOrCreateSettlementPeriod(int _index);
		List<? extends FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder> getSettlementPeriod();
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod settlementPeriod0);
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod settlementPeriod1, int _idx);
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriod2);
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriod"), processor, FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder.class, getSettlementPeriod());
		}
		

		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriodSchedule  ***********************/
	class FxAccrualSettlementPeriodScheduleImpl implements FxAccrualSettlementPeriodSchedule {
		private final List<? extends FxAccrualSettlementPeriod> settlementPeriod;
		
		protected FxAccrualSettlementPeriodScheduleImpl(FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder) {
			this.settlementPeriod = ofNullable(builder.getSettlementPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriod")
		public List<? extends FxAccrualSettlementPeriod> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder toBuilder() {
			FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder builder) {
			ofNullable(getSettlementPeriod()).ifPresent(builder::setSettlementPeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriod, _that.getSettlementPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriod != null ? settlementPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodSchedule {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriodSchedule  ***********************/
	class FxAccrualSettlementPeriodScheduleBuilderImpl implements FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder {
	
		protected List<FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder> settlementPeriod = new ArrayList<>();
	
		public FxAccrualSettlementPeriodScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriod")
		public List<? extends FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		public FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder getOrCreateSettlementPeriod(int _index) {
		
			if (settlementPeriod==null) {
				this.settlementPeriod = new ArrayList<>();
			}
			FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder result;
			return getIndex(settlementPeriod, _index, () -> {
						FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder newSettlementPeriod = FxAccrualSettlementPeriod.builder();
						return newSettlementPeriod;
					});
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod settlementPeriod) {
			if (settlementPeriod!=null) this.settlementPeriod.add(settlementPeriod.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(FxAccrualSettlementPeriod settlementPeriod, int _idx) {
			getIndex(this.settlementPeriod, _idx, () -> settlementPeriod.toBuilder());
			return this;
		}
		@Override 
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriods) {
			if (settlementPeriods != null) {
				for (FxAccrualSettlementPeriod toAdd : settlementPeriods) {
					this.settlementPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriod")
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxAccrualSettlementPeriod> settlementPeriods) {
			if (settlementPeriods == null)  {
				this.settlementPeriod = new ArrayList<>();
			}
			else {
				this.settlementPeriod = settlementPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxAccrualSettlementPeriodSchedule build() {
			return new FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder prune() {
			settlementPeriod = settlementPeriod.stream().filter(b->b!=null).<FxAccrualSettlementPeriod.FxAccrualSettlementPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriod()!=null && getSettlementPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder o = (FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriod(), o.getSettlementPeriod(), this::getOrCreateSettlementPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriod, _that.getSettlementPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriod != null ? settlementPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodScheduleBuilder {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}
}
