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
import fpml.confirmation.FxTargetSettlementPeriod;
import fpml.confirmation.FxTargetSettlementPeriodSchedule;
import fpml.confirmation.FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder;
import fpml.confirmation.FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilderImpl;
import fpml.confirmation.FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleImpl;
import fpml.confirmation.meta.FxTargetSettlementPeriodScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetSettlementPeriodSchedule", builder=FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilderImpl.class, version="${project.version}")
public interface FxTargetSettlementPeriodSchedule extends RosettaModelObject {

	FxTargetSettlementPeriodScheduleMeta metaData = new FxTargetSettlementPeriodScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines each settlement period in the tabular/matrix representation of the product.
	 */
	List<? extends FxTargetSettlementPeriod> getSettlementPeriod();

	/*********************** Build Methods  ***********************/
	FxTargetSettlementPeriodSchedule build();
	
	FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder toBuilder();
	
	static FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder() {
		return new FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetSettlementPeriodSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetSettlementPeriodSchedule> getType() {
		return FxTargetSettlementPeriodSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriod"), processor, FxTargetSettlementPeriod.class, getSettlementPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetSettlementPeriodScheduleBuilder extends FxTargetSettlementPeriodSchedule, RosettaModelObjectBuilder {
		FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder getOrCreateSettlementPeriod(int _index);
		List<? extends FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder> getSettlementPeriod();
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod settlementPeriod0);
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod settlementPeriod1, int _idx);
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriod2);
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriod"), processor, FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder.class, getSettlementPeriod());
		}
		

		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetSettlementPeriodSchedule  ***********************/
	class FxTargetSettlementPeriodScheduleImpl implements FxTargetSettlementPeriodSchedule {
		private final List<? extends FxTargetSettlementPeriod> settlementPeriod;
		
		protected FxTargetSettlementPeriodScheduleImpl(FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder) {
			this.settlementPeriod = ofNullable(builder.getSettlementPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriod")
		public List<? extends FxTargetSettlementPeriod> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule build() {
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder toBuilder() {
			FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder builder) {
			ofNullable(getSettlementPeriod()).ifPresent(builder::setSettlementPeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetSettlementPeriodSchedule _that = getType().cast(o);
		
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
			return "FxTargetSettlementPeriodSchedule {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetSettlementPeriodSchedule  ***********************/
	class FxTargetSettlementPeriodScheduleBuilderImpl implements FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder {
	
		protected List<FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder> settlementPeriod = new ArrayList<>();
	
		public FxTargetSettlementPeriodScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriod")
		public List<? extends FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder> getSettlementPeriod() {
			return settlementPeriod;
		}
		
		public FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder getOrCreateSettlementPeriod(int _index) {
		
			if (settlementPeriod==null) {
				this.settlementPeriod = new ArrayList<>();
			}
			FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder result;
			return getIndex(settlementPeriod, _index, () -> {
						FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder newSettlementPeriod = FxTargetSettlementPeriod.builder();
						return newSettlementPeriod;
					});
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod settlementPeriod) {
			if (settlementPeriod!=null) this.settlementPeriod.add(settlementPeriod.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(FxTargetSettlementPeriod settlementPeriod, int _idx) {
			getIndex(this.settlementPeriod, _idx, () -> settlementPeriod.toBuilder());
			return this;
		}
		@Override 
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder addSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriods) {
			if (settlementPeriods != null) {
				for (FxTargetSettlementPeriod toAdd : settlementPeriods) {
					this.settlementPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriod")
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder setSettlementPeriod(List<? extends FxTargetSettlementPeriod> settlementPeriods) {
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
		public FxTargetSettlementPeriodSchedule build() {
			return new FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleImpl(this);
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder prune() {
			settlementPeriod = settlementPeriod.stream().filter(b->b!=null).<FxTargetSettlementPeriod.FxTargetSettlementPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriod()!=null && getSettlementPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder o = (FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriod(), o.getSettlementPeriod(), this::getOrCreateSettlementPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetSettlementPeriodSchedule _that = getType().cast(o);
		
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
			return "FxTargetSettlementPeriodScheduleBuilder {" +
				"settlementPeriod=" + this.settlementPeriod +
			'}';
		}
	}
}
