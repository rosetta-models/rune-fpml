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
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrual.FxAccrualBuilder;
import fpml.confirmation.FxAccrual.FxAccrualBuilderImpl;
import fpml.confirmation.FxAccrual.FxAccrualImpl;
import fpml.confirmation.FxAccrualRegion;
import fpml.confirmation.FxFixingSchedule;
import fpml.confirmation.FxRateObservable;
import fpml.confirmation.meta.FxAccrualMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Accrual calculation process.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrual", builder=FxAccrual.FxAccrualBuilderImpl.class, version="${project.version}")
public interface FxAccrual extends RosettaModelObject {

	FxAccrualMeta metaData = new FxAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Contains the quoted currency pair, and the information source for fixing FX rate.
	 */
	List<? extends FxRateObservable> getObservable();
	/**
	 * Defines the regions of the spot rate where fixings generate an accumulation of notional.
	 */
	List<? extends FxAccrualRegion> getAccrualRegion();
	/**
	 * Describes a parametric schedule of fixing dates.
	 */
	FxFixingSchedule getFixingSchedule();
	String getId();

	/*********************** Build Methods  ***********************/
	FxAccrual build();
	
	FxAccrual.FxAccrualBuilder toBuilder();
	
	static FxAccrual.FxAccrualBuilder builder() {
		return new FxAccrual.FxAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrual> getType() {
		return FxAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observable"), processor, FxRateObservable.class, getObservable());
		processRosetta(path.newSubPath("accrualRegion"), processor, FxAccrualRegion.class, getAccrualRegion());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingSchedule.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualBuilder extends FxAccrual, RosettaModelObjectBuilder {
		FxRateObservable.FxRateObservableBuilder getOrCreateObservable(int _index);
		List<? extends FxRateObservable.FxRateObservableBuilder> getObservable();
		FxAccrualRegion.FxAccrualRegionBuilder getOrCreateAccrualRegion(int _index);
		List<? extends FxAccrualRegion.FxAccrualRegionBuilder> getAccrualRegion();
		FxFixingSchedule.FxFixingScheduleBuilder getOrCreateFixingSchedule();
		FxFixingSchedule.FxFixingScheduleBuilder getFixingSchedule();
		FxAccrual.FxAccrualBuilder addObservable(FxRateObservable observable0);
		FxAccrual.FxAccrualBuilder addObservable(FxRateObservable observable1, int _idx);
		FxAccrual.FxAccrualBuilder addObservable(List<? extends FxRateObservable> observable2);
		FxAccrual.FxAccrualBuilder setObservable(List<? extends FxRateObservable> observable3);
		FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion accrualRegion0);
		FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion accrualRegion1, int _idx);
		FxAccrual.FxAccrualBuilder addAccrualRegion(List<? extends FxAccrualRegion> accrualRegion2);
		FxAccrual.FxAccrualBuilder setAccrualRegion(List<? extends FxAccrualRegion> accrualRegion3);
		FxAccrual.FxAccrualBuilder setFixingSchedule(FxFixingSchedule fixingSchedule);
		FxAccrual.FxAccrualBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observable"), processor, FxRateObservable.FxRateObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("accrualRegion"), processor, FxAccrualRegion.FxAccrualRegionBuilder.class, getAccrualRegion());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingSchedule.FxFixingScheduleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxAccrual.FxAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrual  ***********************/
	class FxAccrualImpl implements FxAccrual {
		private final List<? extends FxRateObservable> observable;
		private final List<? extends FxAccrualRegion> accrualRegion;
		private final FxFixingSchedule fixingSchedule;
		private final String id;
		
		protected FxAccrualImpl(FxAccrual.FxAccrualBuilder builder) {
			this.observable = ofNullable(builder.getObservable()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accrualRegion = ofNullable(builder.getAccrualRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fixingSchedule = ofNullable(builder.getFixingSchedule()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("observable")
		public List<? extends FxRateObservable> getObservable() {
			return observable;
		}
		
		@Override
		@RosettaAttribute("accrualRegion")
		public List<? extends FxAccrualRegion> getAccrualRegion() {
			return accrualRegion;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxFixingSchedule getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxAccrual build() {
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder toBuilder() {
			FxAccrual.FxAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrual.FxAccrualBuilder builder) {
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getAccrualRegion()).ifPresent(builder::setAccrualRegion);
			ofNullable(getFixingSchedule()).ifPresent(builder::setFixingSchedule);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrual _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observable, _that.getObservable())) return false;
			if (!ListEquals.listEquals(accrualRegion, _that.getAccrualRegion())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (accrualRegion != null ? accrualRegion.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrual {" +
				"observable=" + this.observable + ", " +
				"accrualRegion=" + this.accrualRegion + ", " +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrual  ***********************/
	class FxAccrualBuilderImpl implements FxAccrual.FxAccrualBuilder {
	
		protected List<FxRateObservable.FxRateObservableBuilder> observable = new ArrayList<>();
		protected List<FxAccrualRegion.FxAccrualRegionBuilder> accrualRegion = new ArrayList<>();
		protected FxFixingSchedule.FxFixingScheduleBuilder fixingSchedule;
		protected String id;
	
		public FxAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observable")
		public List<? extends FxRateObservable.FxRateObservableBuilder> getObservable() {
			return observable;
		}
		
		public FxRateObservable.FxRateObservableBuilder getOrCreateObservable(int _index) {
		
			if (observable==null) {
				this.observable = new ArrayList<>();
			}
			FxRateObservable.FxRateObservableBuilder result;
			return getIndex(observable, _index, () -> {
						FxRateObservable.FxRateObservableBuilder newObservable = FxRateObservable.builder();
						return newObservable;
					});
		}
		
		@Override
		@RosettaAttribute("accrualRegion")
		public List<? extends FxAccrualRegion.FxAccrualRegionBuilder> getAccrualRegion() {
			return accrualRegion;
		}
		
		public FxAccrualRegion.FxAccrualRegionBuilder getOrCreateAccrualRegion(int _index) {
		
			if (accrualRegion==null) {
				this.accrualRegion = new ArrayList<>();
			}
			FxAccrualRegion.FxAccrualRegionBuilder result;
			return getIndex(accrualRegion, _index, () -> {
						FxAccrualRegion.FxAccrualRegionBuilder newAccrualRegion = FxAccrualRegion.builder();
						return newAccrualRegion;
					});
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxFixingSchedule.FxFixingScheduleBuilder getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder getOrCreateFixingSchedule() {
			FxFixingSchedule.FxFixingScheduleBuilder result;
			if (fixingSchedule!=null) {
				result = fixingSchedule;
			}
			else {
				result = fixingSchedule = FxFixingSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addObservable(FxRateObservable observable) {
			if (observable!=null) this.observable.add(observable.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addObservable(FxRateObservable observable, int _idx) {
			getIndex(this.observable, _idx, () -> observable.toBuilder());
			return this;
		}
		@Override 
		public FxAccrual.FxAccrualBuilder addObservable(List<? extends FxRateObservable> observables) {
			if (observables != null) {
				for (FxRateObservable toAdd : observables) {
					this.observable.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("observable")
		public FxAccrual.FxAccrualBuilder setObservable(List<? extends FxRateObservable> observables) {
			if (observables == null)  {
				this.observable = new ArrayList<>();
			}
			else {
				this.observable = observables.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion accrualRegion) {
			if (accrualRegion!=null) this.accrualRegion.add(accrualRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion accrualRegion, int _idx) {
			getIndex(this.accrualRegion, _idx, () -> accrualRegion.toBuilder());
			return this;
		}
		@Override 
		public FxAccrual.FxAccrualBuilder addAccrualRegion(List<? extends FxAccrualRegion> accrualRegions) {
			if (accrualRegions != null) {
				for (FxAccrualRegion toAdd : accrualRegions) {
					this.accrualRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualRegion")
		public FxAccrual.FxAccrualBuilder setAccrualRegion(List<? extends FxAccrualRegion> accrualRegions) {
			if (accrualRegions == null)  {
				this.accrualRegion = new ArrayList<>();
			}
			else {
				this.accrualRegion = accrualRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxAccrual.FxAccrualBuilder setFixingSchedule(FxFixingSchedule fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxAccrual.FxAccrualBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxAccrual build() {
			return new FxAccrual.FxAccrualImpl(this);
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrual.FxAccrualBuilder prune() {
			observable = observable.stream().filter(b->b!=null).<FxRateObservable.FxRateObservableBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			accrualRegion = accrualRegion.stream().filter(b->b!=null).<FxAccrualRegion.FxAccrualRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fixingSchedule!=null && !fixingSchedule.prune().hasData()) fixingSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservable()!=null && getObservable().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccrualRegion()!=null && getAccrualRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFixingSchedule()!=null && getFixingSchedule().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrual.FxAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrual.FxAccrualBuilder o = (FxAccrual.FxAccrualBuilder) other;
			
			merger.mergeRosetta(getObservable(), o.getObservable(), this::getOrCreateObservable);
			merger.mergeRosetta(getAccrualRegion(), o.getAccrualRegion(), this::getOrCreateAccrualRegion);
			merger.mergeRosetta(getFixingSchedule(), o.getFixingSchedule(), this::setFixingSchedule);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrual _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observable, _that.getObservable())) return false;
			if (!ListEquals.listEquals(accrualRegion, _that.getAccrualRegion())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (accrualRegion != null ? accrualRegion.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualBuilder {" +
				"observable=" + this.observable + ", " +
				"accrualRegion=" + this.accrualRegion + ", " +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
