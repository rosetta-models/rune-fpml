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
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder;
import fpml.confirmation.FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilderImpl;
import fpml.confirmation.FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelImpl;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import fpml.confirmation.meta.FacilityLoanContractDetailsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model used to reference a facility by either identifier or summary, within various notifications.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityLoanContractDetailsModel", builder=FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilderImpl.class, version="${project.version}")
public interface FacilityLoanContractDetailsModel extends RosettaModelObject {

	FacilityLoanContractDetailsModelMeta metaData = new FacilityLoanContractDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	FacilityDetailsModel getFacilityDetailsModel();
	List<? extends FacilityLoanContractDetailsModelChoice0> getFacilityLoanContractDetailsModelChoice0();
	List<? extends FacilityLoanContractDetailsModelChoice1> getFacilityLoanContractDetailsModelChoice1();

	/*********************** Build Methods  ***********************/
	FacilityLoanContractDetailsModel build();
	
	FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder toBuilder();
	
	static FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder builder() {
		return new FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityLoanContractDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityLoanContractDetailsModel> getType() {
		return FacilityLoanContractDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("facilityLoanContractDetailsModelChoice0"), processor, FacilityLoanContractDetailsModelChoice0.class, getFacilityLoanContractDetailsModelChoice0());
		processRosetta(path.newSubPath("facilityLoanContractDetailsModelChoice1"), processor, FacilityLoanContractDetailsModelChoice1.class, getFacilityLoanContractDetailsModelChoice1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityLoanContractDetailsModelBuilder extends FacilityLoanContractDetailsModel, RosettaModelObjectBuilder {
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder getOrCreateFacilityLoanContractDetailsModelChoice0(int _index);
		List<? extends FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder> getFacilityLoanContractDetailsModelChoice0();
		FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder getOrCreateFacilityLoanContractDetailsModelChoice1(int _index);
		List<? extends FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder> getFacilityLoanContractDetailsModelChoice1();
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice0(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice00);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice0(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice01, int _idx);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice0(List<? extends FacilityLoanContractDetailsModelChoice0> facilityLoanContractDetailsModelChoice02);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder setFacilityLoanContractDetailsModelChoice0(List<? extends FacilityLoanContractDetailsModelChoice0> facilityLoanContractDetailsModelChoice03);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice1(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice10);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice1(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice11, int _idx);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice1(List<? extends FacilityLoanContractDetailsModelChoice1> facilityLoanContractDetailsModelChoice12);
		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder setFacilityLoanContractDetailsModelChoice1(List<? extends FacilityLoanContractDetailsModelChoice1> facilityLoanContractDetailsModelChoice13);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("facilityLoanContractDetailsModelChoice0"), processor, FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder.class, getFacilityLoanContractDetailsModelChoice0());
			processRosetta(path.newSubPath("facilityLoanContractDetailsModelChoice1"), processor, FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder.class, getFacilityLoanContractDetailsModelChoice1());
		}
		

		FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityLoanContractDetailsModel  ***********************/
	class FacilityLoanContractDetailsModelImpl implements FacilityLoanContractDetailsModel {
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends FacilityLoanContractDetailsModelChoice0> facilityLoanContractDetailsModelChoice0;
		private final List<? extends FacilityLoanContractDetailsModelChoice1> facilityLoanContractDetailsModelChoice1;
		
		protected FacilityLoanContractDetailsModelImpl(FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder builder) {
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.facilityLoanContractDetailsModelChoice0 = ofNullable(builder.getFacilityLoanContractDetailsModelChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityLoanContractDetailsModelChoice1 = ofNullable(builder.getFacilityLoanContractDetailsModelChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModelChoice0")
		public List<? extends FacilityLoanContractDetailsModelChoice0> getFacilityLoanContractDetailsModelChoice0() {
			return facilityLoanContractDetailsModelChoice0;
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModelChoice1")
		public List<? extends FacilityLoanContractDetailsModelChoice1> getFacilityLoanContractDetailsModelChoice1() {
			return facilityLoanContractDetailsModelChoice1;
		}
		
		@Override
		public FacilityLoanContractDetailsModel build() {
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder toBuilder() {
			FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder builder) {
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getFacilityLoanContractDetailsModelChoice0()).ifPresent(builder::setFacilityLoanContractDetailsModelChoice0);
			ofNullable(getFacilityLoanContractDetailsModelChoice1()).ifPresent(builder::setFacilityLoanContractDetailsModelChoice1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityLoanContractDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityLoanContractDetailsModelChoice0, _that.getFacilityLoanContractDetailsModelChoice0())) return false;
			if (!ListEquals.listEquals(facilityLoanContractDetailsModelChoice1, _that.getFacilityLoanContractDetailsModelChoice1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityLoanContractDetailsModelChoice0 != null ? facilityLoanContractDetailsModelChoice0.hashCode() : 0);
			_result = 31 * _result + (facilityLoanContractDetailsModelChoice1 != null ? facilityLoanContractDetailsModelChoice1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityLoanContractDetailsModel {" +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"facilityLoanContractDetailsModelChoice0=" + this.facilityLoanContractDetailsModelChoice0 + ", " +
				"facilityLoanContractDetailsModelChoice1=" + this.facilityLoanContractDetailsModelChoice1 +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityLoanContractDetailsModel  ***********************/
	class FacilityLoanContractDetailsModelBuilderImpl implements FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder {
	
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder> facilityLoanContractDetailsModelChoice0 = new ArrayList<>();
		protected List<FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder> facilityLoanContractDetailsModelChoice1 = new ArrayList<>();
	
		public FacilityLoanContractDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel() {
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			if (facilityDetailsModel!=null) {
				result = facilityDetailsModel;
			}
			else {
				result = facilityDetailsModel = FacilityDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModelChoice0")
		public List<? extends FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder> getFacilityLoanContractDetailsModelChoice0() {
			return facilityLoanContractDetailsModelChoice0;
		}
		
		public FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder getOrCreateFacilityLoanContractDetailsModelChoice0(int _index) {
		
			if (facilityLoanContractDetailsModelChoice0==null) {
				this.facilityLoanContractDetailsModelChoice0 = new ArrayList<>();
			}
			FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder result;
			return getIndex(facilityLoanContractDetailsModelChoice0, _index, () -> {
						FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder newFacilityLoanContractDetailsModelChoice0 = FacilityLoanContractDetailsModelChoice0.builder();
						return newFacilityLoanContractDetailsModelChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("facilityLoanContractDetailsModelChoice1")
		public List<? extends FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder> getFacilityLoanContractDetailsModelChoice1() {
			return facilityLoanContractDetailsModelChoice1;
		}
		
		public FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder getOrCreateFacilityLoanContractDetailsModelChoice1(int _index) {
		
			if (facilityLoanContractDetailsModelChoice1==null) {
				this.facilityLoanContractDetailsModelChoice1 = new ArrayList<>();
			}
			FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder result;
			return getIndex(facilityLoanContractDetailsModelChoice1, _index, () -> {
						FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder newFacilityLoanContractDetailsModelChoice1 = FacilityLoanContractDetailsModelChoice1.builder();
						return newFacilityLoanContractDetailsModelChoice1;
					});
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice0(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
			if (facilityLoanContractDetailsModelChoice0!=null) this.facilityLoanContractDetailsModelChoice0.add(facilityLoanContractDetailsModelChoice0.toBuilder());
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice0(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0, int _idx) {
			getIndex(this.facilityLoanContractDetailsModelChoice0, _idx, () -> facilityLoanContractDetailsModelChoice0.toBuilder());
			return this;
		}
		@Override 
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice0(List<? extends FacilityLoanContractDetailsModelChoice0> facilityLoanContractDetailsModelChoice0s) {
			if (facilityLoanContractDetailsModelChoice0s != null) {
				for (FacilityLoanContractDetailsModelChoice0 toAdd : facilityLoanContractDetailsModelChoice0s) {
					this.facilityLoanContractDetailsModelChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityLoanContractDetailsModelChoice0")
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder setFacilityLoanContractDetailsModelChoice0(List<? extends FacilityLoanContractDetailsModelChoice0> facilityLoanContractDetailsModelChoice0s) {
			if (facilityLoanContractDetailsModelChoice0s == null)  {
				this.facilityLoanContractDetailsModelChoice0 = new ArrayList<>();
			}
			else {
				this.facilityLoanContractDetailsModelChoice0 = facilityLoanContractDetailsModelChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice1(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
			if (facilityLoanContractDetailsModelChoice1!=null) this.facilityLoanContractDetailsModelChoice1.add(facilityLoanContractDetailsModelChoice1.toBuilder());
			return this;
		}
		
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice1(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1, int _idx) {
			getIndex(this.facilityLoanContractDetailsModelChoice1, _idx, () -> facilityLoanContractDetailsModelChoice1.toBuilder());
			return this;
		}
		@Override 
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder addFacilityLoanContractDetailsModelChoice1(List<? extends FacilityLoanContractDetailsModelChoice1> facilityLoanContractDetailsModelChoice1s) {
			if (facilityLoanContractDetailsModelChoice1s != null) {
				for (FacilityLoanContractDetailsModelChoice1 toAdd : facilityLoanContractDetailsModelChoice1s) {
					this.facilityLoanContractDetailsModelChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityLoanContractDetailsModelChoice1")
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder setFacilityLoanContractDetailsModelChoice1(List<? extends FacilityLoanContractDetailsModelChoice1> facilityLoanContractDetailsModelChoice1s) {
			if (facilityLoanContractDetailsModelChoice1s == null)  {
				this.facilityLoanContractDetailsModelChoice1 = new ArrayList<>();
			}
			else {
				this.facilityLoanContractDetailsModelChoice1 = facilityLoanContractDetailsModelChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FacilityLoanContractDetailsModel build() {
			return new FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelImpl(this);
		}
		
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder prune() {
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			facilityLoanContractDetailsModelChoice0 = facilityLoanContractDetailsModelChoice0.stream().filter(b->b!=null).<FacilityLoanContractDetailsModelChoice0.FacilityLoanContractDetailsModelChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityLoanContractDetailsModelChoice1 = facilityLoanContractDetailsModelChoice1.stream().filter(b->b!=null).<FacilityLoanContractDetailsModelChoice1.FacilityLoanContractDetailsModelChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getFacilityLoanContractDetailsModelChoice0()!=null && getFacilityLoanContractDetailsModelChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityLoanContractDetailsModelChoice1()!=null && getFacilityLoanContractDetailsModelChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder o = (FacilityLoanContractDetailsModel.FacilityLoanContractDetailsModelBuilder) other;
			
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getFacilityLoanContractDetailsModelChoice0(), o.getFacilityLoanContractDetailsModelChoice0(), this::getOrCreateFacilityLoanContractDetailsModelChoice0);
			merger.mergeRosetta(getFacilityLoanContractDetailsModelChoice1(), o.getFacilityLoanContractDetailsModelChoice1(), this::getOrCreateFacilityLoanContractDetailsModelChoice1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityLoanContractDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(facilityLoanContractDetailsModelChoice0, _that.getFacilityLoanContractDetailsModelChoice0())) return false;
			if (!ListEquals.listEquals(facilityLoanContractDetailsModelChoice1, _that.getFacilityLoanContractDetailsModelChoice1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (facilityLoanContractDetailsModelChoice0 != null ? facilityLoanContractDetailsModelChoice0.hashCode() : 0);
			_result = 31 * _result + (facilityLoanContractDetailsModelChoice1 != null ? facilityLoanContractDetailsModelChoice1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityLoanContractDetailsModelBuilder {" +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"facilityLoanContractDetailsModelChoice0=" + this.facilityLoanContractDetailsModelChoice0 + ", " +
				"facilityLoanContractDetailsModelChoice1=" + this.facilityLoanContractDetailsModelChoice1 +
			'}';
		}
	}
}
