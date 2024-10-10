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
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder;
import fpml.confirmation.MultiDimensionalPricingData.MultiDimensionalPricingDataBuilderImpl;
import fpml.confirmation.MultiDimensionalPricingData.MultiDimensionalPricingDataImpl;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.meta.MultiDimensionalPricingDataMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A pricing data set that contains a series of points with coordinates. It is a sparse matrix representation of a multi-dimensional matrix.
 * @version ${project.version}
 */
@RosettaDataType(value="MultiDimensionalPricingData", builder=MultiDimensionalPricingData.MultiDimensionalPricingDataBuilderImpl.class, version="${project.version}")
public interface MultiDimensionalPricingData extends RosettaModelObject {

	MultiDimensionalPricingDataMeta metaData = new MultiDimensionalPricingDataMeta();

	/*********************** Getter Methods  ***********************/
	QuotationCharacteristicsModel getQuotationCharacteristicsModel();
	List<? extends PricingStructurePoint> getPoint();

	/*********************** Build Methods  ***********************/
	MultiDimensionalPricingData build();
	
	MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder toBuilder();
	
	static MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder builder() {
		return new MultiDimensionalPricingData.MultiDimensionalPricingDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MultiDimensionalPricingData> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MultiDimensionalPricingData> getType() {
		return MultiDimensionalPricingData.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotationCharacteristicsModel"), processor, QuotationCharacteristicsModel.class, getQuotationCharacteristicsModel());
		processRosetta(path.newSubPath("point"), processor, PricingStructurePoint.class, getPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MultiDimensionalPricingDataBuilder extends MultiDimensionalPricingData, RosettaModelObjectBuilder {
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getOrCreateQuotationCharacteristicsModel();
		QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getQuotationCharacteristicsModel();
		PricingStructurePoint.PricingStructurePointBuilder getOrCreatePoint(int _index);
		List<? extends PricingStructurePoint.PricingStructurePointBuilder> getPoint();
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder setQuotationCharacteristicsModel(QuotationCharacteristicsModel quotationCharacteristicsModel);
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder addPoint(PricingStructurePoint point0);
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder addPoint(PricingStructurePoint point1, int _idx);
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder addPoint(List<? extends PricingStructurePoint> point2);
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder setPoint(List<? extends PricingStructurePoint> point3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotationCharacteristicsModel"), processor, QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder.class, getQuotationCharacteristicsModel());
			processRosetta(path.newSubPath("point"), processor, PricingStructurePoint.PricingStructurePointBuilder.class, getPoint());
		}
		

		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder prune();
	}

	/*********************** Immutable Implementation of MultiDimensionalPricingData  ***********************/
	class MultiDimensionalPricingDataImpl implements MultiDimensionalPricingData {
		private final QuotationCharacteristicsModel quotationCharacteristicsModel;
		private final List<? extends PricingStructurePoint> point;
		
		protected MultiDimensionalPricingDataImpl(MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder builder) {
			this.quotationCharacteristicsModel = ofNullable(builder.getQuotationCharacteristicsModel()).map(f->f.build()).orElse(null);
			this.point = ofNullable(builder.getPoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationCharacteristicsModel getQuotationCharacteristicsModel() {
			return quotationCharacteristicsModel;
		}
		
		@Override
		@RosettaAttribute("point")
		public List<? extends PricingStructurePoint> getPoint() {
			return point;
		}
		
		@Override
		public MultiDimensionalPricingData build() {
			return this;
		}
		
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder toBuilder() {
			MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder builder) {
			ofNullable(getQuotationCharacteristicsModel()).ifPresent(builder::setQuotationCharacteristicsModel);
			ofNullable(getPoint()).ifPresent(builder::setPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultiDimensionalPricingData _that = getType().cast(o);
		
			if (!Objects.equals(quotationCharacteristicsModel, _that.getQuotationCharacteristicsModel())) return false;
			if (!ListEquals.listEquals(point, _that.getPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationCharacteristicsModel != null ? quotationCharacteristicsModel.hashCode() : 0);
			_result = 31 * _result + (point != null ? point.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultiDimensionalPricingData {" +
				"quotationCharacteristicsModel=" + this.quotationCharacteristicsModel + ", " +
				"point=" + this.point +
			'}';
		}
	}

	/*********************** Builder Implementation of MultiDimensionalPricingData  ***********************/
	class MultiDimensionalPricingDataBuilderImpl implements MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder {
	
		protected QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder quotationCharacteristicsModel;
		protected List<PricingStructurePoint.PricingStructurePointBuilder> point = new ArrayList<>();
	
		public MultiDimensionalPricingDataBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getQuotationCharacteristicsModel() {
			return quotationCharacteristicsModel;
		}
		
		@Override
		public QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder getOrCreateQuotationCharacteristicsModel() {
			QuotationCharacteristicsModel.QuotationCharacteristicsModelBuilder result;
			if (quotationCharacteristicsModel!=null) {
				result = quotationCharacteristicsModel;
			}
			else {
				result = quotationCharacteristicsModel = QuotationCharacteristicsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("point")
		public List<? extends PricingStructurePoint.PricingStructurePointBuilder> getPoint() {
			return point;
		}
		
		public PricingStructurePoint.PricingStructurePointBuilder getOrCreatePoint(int _index) {
		
			if (point==null) {
				this.point = new ArrayList<>();
			}
			PricingStructurePoint.PricingStructurePointBuilder result;
			return getIndex(point, _index, () -> {
						PricingStructurePoint.PricingStructurePointBuilder newPoint = PricingStructurePoint.builder();
						return newPoint;
					});
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristicsModel")
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder setQuotationCharacteristicsModel(QuotationCharacteristicsModel quotationCharacteristicsModel) {
			this.quotationCharacteristicsModel = quotationCharacteristicsModel==null?null:quotationCharacteristicsModel.toBuilder();
			return this;
		}
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder addPoint(PricingStructurePoint point) {
			if (point!=null) this.point.add(point.toBuilder());
			return this;
		}
		
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder addPoint(PricingStructurePoint point, int _idx) {
			getIndex(this.point, _idx, () -> point.toBuilder());
			return this;
		}
		@Override 
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder addPoint(List<? extends PricingStructurePoint> points) {
			if (points != null) {
				for (PricingStructurePoint toAdd : points) {
					this.point.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("point")
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder setPoint(List<? extends PricingStructurePoint> points) {
			if (points == null)  {
				this.point = new ArrayList<>();
			}
			else {
				this.point = points.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public MultiDimensionalPricingData build() {
			return new MultiDimensionalPricingData.MultiDimensionalPricingDataImpl(this);
		}
		
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder prune() {
			if (quotationCharacteristicsModel!=null && !quotationCharacteristicsModel.prune().hasData()) quotationCharacteristicsModel = null;
			point = point.stream().filter(b->b!=null).<PricingStructurePoint.PricingStructurePointBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotationCharacteristicsModel()!=null && getQuotationCharacteristicsModel().hasData()) return true;
			if (getPoint()!=null && getPoint().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder o = (MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder) other;
			
			merger.mergeRosetta(getQuotationCharacteristicsModel(), o.getQuotationCharacteristicsModel(), this::setQuotationCharacteristicsModel);
			merger.mergeRosetta(getPoint(), o.getPoint(), this::getOrCreatePoint);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultiDimensionalPricingData _that = getType().cast(o);
		
			if (!Objects.equals(quotationCharacteristicsModel, _that.getQuotationCharacteristicsModel())) return false;
			if (!ListEquals.listEquals(point, _that.getPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationCharacteristicsModel != null ? quotationCharacteristicsModel.hashCode() : 0);
			_result = 31 * _result + (point != null ? point.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultiDimensionalPricingDataBuilder {" +
				"quotationCharacteristicsModel=" + this.quotationCharacteristicsModel + ", " +
				"point=" + this.point +
			'}';
		}
	}
}
