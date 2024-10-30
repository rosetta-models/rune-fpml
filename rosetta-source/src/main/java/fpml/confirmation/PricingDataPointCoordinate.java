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
import fpml.confirmation.PricingDataPointCoordinate;
import fpml.confirmation.PricingDataPointCoordinate.PricingDataPointCoordinateBuilder;
import fpml.confirmation.PricingDataPointCoordinate.PricingDataPointCoordinateBuilderImpl;
import fpml.confirmation.PricingDataPointCoordinate.PricingDataPointCoordinateImpl;
import fpml.confirmation.PricingStructureIndexModel;
import fpml.confirmation.meta.PricingDataPointCoordinateMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A set of index values that identify a pricing data point. For example: (strike = 17%, expiration = 6M, term = 1Y.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PricingDataPointCoordinate", builder=PricingDataPointCoordinate.PricingDataPointCoordinateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PricingDataPointCoordinate extends RosettaModelObject {

	PricingDataPointCoordinateMeta metaData = new PricingDataPointCoordinateMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PricingStructureIndexModel> getPricingStructureIndexModel();
	String getId();

	/*********************** Build Methods  ***********************/
	PricingDataPointCoordinate build();
	
	PricingDataPointCoordinate.PricingDataPointCoordinateBuilder toBuilder();
	
	static PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder() {
		return new PricingDataPointCoordinate.PricingDataPointCoordinateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingDataPointCoordinate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingDataPointCoordinate> getType() {
		return PricingDataPointCoordinate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pricingStructureIndexModel"), processor, PricingStructureIndexModel.class, getPricingStructureIndexModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingDataPointCoordinateBuilder extends PricingDataPointCoordinate, RosettaModelObjectBuilder {
		PricingStructureIndexModel.PricingStructureIndexModelBuilder getOrCreatePricingStructureIndexModel(int _index);
		List<? extends PricingStructureIndexModel.PricingStructureIndexModelBuilder> getPricingStructureIndexModel();
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingStructureIndexModel(PricingStructureIndexModel pricingStructureIndexModel0);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingStructureIndexModel(PricingStructureIndexModel pricingStructureIndexModel1, int _idx);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingStructureIndexModel(List<? extends PricingStructureIndexModel> pricingStructureIndexModel2);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setPricingStructureIndexModel(List<? extends PricingStructureIndexModel> pricingStructureIndexModel3);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pricingStructureIndexModel"), processor, PricingStructureIndexModel.PricingStructureIndexModelBuilder.class, getPricingStructureIndexModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder prune();
	}

	/*********************** Immutable Implementation of PricingDataPointCoordinate  ***********************/
	class PricingDataPointCoordinateImpl implements PricingDataPointCoordinate {
		private final List<? extends PricingStructureIndexModel> pricingStructureIndexModel;
		private final String id;
		
		protected PricingDataPointCoordinateImpl(PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder) {
			this.pricingStructureIndexModel = ofNullable(builder.getPricingStructureIndexModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("pricingStructureIndexModel")
		public List<? extends PricingStructureIndexModel> getPricingStructureIndexModel() {
			return pricingStructureIndexModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PricingDataPointCoordinate build() {
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder toBuilder() {
			PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder) {
			ofNullable(getPricingStructureIndexModel()).ifPresent(builder::setPricingStructureIndexModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDataPointCoordinate _that = getType().cast(o);
		
			if (!ListEquals.listEquals(pricingStructureIndexModel, _that.getPricingStructureIndexModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingStructureIndexModel != null ? pricingStructureIndexModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDataPointCoordinate {" +
				"pricingStructureIndexModel=" + this.pricingStructureIndexModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingDataPointCoordinate  ***********************/
	class PricingDataPointCoordinateBuilderImpl implements PricingDataPointCoordinate.PricingDataPointCoordinateBuilder {
	
		protected List<PricingStructureIndexModel.PricingStructureIndexModelBuilder> pricingStructureIndexModel = new ArrayList<>();
		protected String id;
	
		public PricingDataPointCoordinateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pricingStructureIndexModel")
		public List<? extends PricingStructureIndexModel.PricingStructureIndexModelBuilder> getPricingStructureIndexModel() {
			return pricingStructureIndexModel;
		}
		
		@Override
		public PricingStructureIndexModel.PricingStructureIndexModelBuilder getOrCreatePricingStructureIndexModel(int _index) {
		
			if (pricingStructureIndexModel==null) {
				this.pricingStructureIndexModel = new ArrayList<>();
			}
			PricingStructureIndexModel.PricingStructureIndexModelBuilder result;
			return getIndex(pricingStructureIndexModel, _index, () -> {
						PricingStructureIndexModel.PricingStructureIndexModelBuilder newPricingStructureIndexModel = PricingStructureIndexModel.builder();
						return newPricingStructureIndexModel;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("pricingStructureIndexModel")
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingStructureIndexModel(PricingStructureIndexModel pricingStructureIndexModel) {
			if (pricingStructureIndexModel!=null) this.pricingStructureIndexModel.add(pricingStructureIndexModel.toBuilder());
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingStructureIndexModel(PricingStructureIndexModel pricingStructureIndexModel, int _idx) {
			getIndex(this.pricingStructureIndexModel, _idx, () -> pricingStructureIndexModel.toBuilder());
			return this;
		}
		@Override 
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingStructureIndexModel(List<? extends PricingStructureIndexModel> pricingStructureIndexModels) {
			if (pricingStructureIndexModels != null) {
				for (PricingStructureIndexModel toAdd : pricingStructureIndexModels) {
					this.pricingStructureIndexModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setPricingStructureIndexModel(List<? extends PricingStructureIndexModel> pricingStructureIndexModels) {
			if (pricingStructureIndexModels == null)  {
				this.pricingStructureIndexModel = new ArrayList<>();
			}
			else {
				this.pricingStructureIndexModel = pricingStructureIndexModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate build() {
			return new PricingDataPointCoordinate.PricingDataPointCoordinateImpl(this);
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder prune() {
			pricingStructureIndexModel = pricingStructureIndexModel.stream().filter(b->b!=null).<PricingStructureIndexModel.PricingStructureIndexModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPricingStructureIndexModel()!=null && getPricingStructureIndexModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingDataPointCoordinate.PricingDataPointCoordinateBuilder o = (PricingDataPointCoordinate.PricingDataPointCoordinateBuilder) other;
			
			merger.mergeRosetta(getPricingStructureIndexModel(), o.getPricingStructureIndexModel(), this::getOrCreatePricingStructureIndexModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDataPointCoordinate _that = getType().cast(o);
		
			if (!ListEquals.listEquals(pricingStructureIndexModel, _that.getPricingStructureIndexModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingStructureIndexModel != null ? pricingStructureIndexModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDataPointCoordinateBuilder {" +
				"pricingStructureIndexModel=" + this.pricingStructureIndexModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
