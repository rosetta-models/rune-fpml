package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import fpml.confirmation.PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder;
import fpml.confirmation.PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilderImpl;
import fpml.confirmation.PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelImpl;
import fpml.confirmation.PricingDataPointCoordinate;
import fpml.confirmation.PricingDataPointCoordinateReference;
import fpml.confirmation.meta.PricingCoordinateOrReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A pricing structure coordinate, or a reference to one. This can be used to either directly define a coordinate or reference an existing coordinate.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingCoordinateOrReferenceModel", builder=PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilderImpl.class, version="${project.version}")
public interface PricingCoordinateOrReferenceModel extends RosettaModelObject {

	PricingCoordinateOrReferenceModelMeta metaData = new PricingCoordinateOrReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An explicit, filled in data point coordinate. This might specify expiration, strike, etc.
	 */
	PricingDataPointCoordinate getCoordinate();
	/**
	 * A reference to a pricing data point coordinate within this document.
	 */
	PricingDataPointCoordinateReference getCoordinateReference();

	/*********************** Build Methods  ***********************/
	PricingCoordinateOrReferenceModel build();
	
	PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder toBuilder();
	
	static PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder builder() {
		return new PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingCoordinateOrReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingCoordinateOrReferenceModel> getType() {
		return PricingCoordinateOrReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("coordinate"), processor, PricingDataPointCoordinate.class, getCoordinate());
		processRosetta(path.newSubPath("coordinateReference"), processor, PricingDataPointCoordinateReference.class, getCoordinateReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingCoordinateOrReferenceModelBuilder extends PricingCoordinateOrReferenceModel, RosettaModelObjectBuilder {
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getOrCreateCoordinate();
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getCoordinate();
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getOrCreateCoordinateReference();
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getCoordinateReference();
		PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder setCoordinate(PricingDataPointCoordinate coordinate);
		PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder setCoordinateReference(PricingDataPointCoordinateReference coordinateReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("coordinate"), processor, PricingDataPointCoordinate.PricingDataPointCoordinateBuilder.class, getCoordinate());
			processRosetta(path.newSubPath("coordinateReference"), processor, PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder.class, getCoordinateReference());
		}
		

		PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of PricingCoordinateOrReferenceModel  ***********************/
	class PricingCoordinateOrReferenceModelImpl implements PricingCoordinateOrReferenceModel {
		private final PricingDataPointCoordinate coordinate;
		private final PricingDataPointCoordinateReference coordinateReference;
		
		protected PricingCoordinateOrReferenceModelImpl(PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder builder) {
			this.coordinate = ofNullable(builder.getCoordinate()).map(f->f.build()).orElse(null);
			this.coordinateReference = ofNullable(builder.getCoordinateReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("coordinate")
		public PricingDataPointCoordinate getCoordinate() {
			return coordinate;
		}
		
		@Override
		@RosettaAttribute("coordinateReference")
		public PricingDataPointCoordinateReference getCoordinateReference() {
			return coordinateReference;
		}
		
		@Override
		public PricingCoordinateOrReferenceModel build() {
			return this;
		}
		
		@Override
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder toBuilder() {
			PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder builder) {
			ofNullable(getCoordinate()).ifPresent(builder::setCoordinate);
			ofNullable(getCoordinateReference()).ifPresent(builder::setCoordinateReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingCoordinateOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(coordinate, _that.getCoordinate())) return false;
			if (!Objects.equals(coordinateReference, _that.getCoordinateReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coordinate != null ? coordinate.hashCode() : 0);
			_result = 31 * _result + (coordinateReference != null ? coordinateReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingCoordinateOrReferenceModel {" +
				"coordinate=" + this.coordinate + ", " +
				"coordinateReference=" + this.coordinateReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingCoordinateOrReferenceModel  ***********************/
	class PricingCoordinateOrReferenceModelBuilderImpl implements PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder {
	
		protected PricingDataPointCoordinate.PricingDataPointCoordinateBuilder coordinate;
		protected PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder coordinateReference;
	
		public PricingCoordinateOrReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("coordinate")
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getCoordinate() {
			return coordinate;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getOrCreateCoordinate() {
			PricingDataPointCoordinate.PricingDataPointCoordinateBuilder result;
			if (coordinate!=null) {
				result = coordinate;
			}
			else {
				result = coordinate = PricingDataPointCoordinate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coordinateReference")
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getCoordinateReference() {
			return coordinateReference;
		}
		
		@Override
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getOrCreateCoordinateReference() {
			PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder result;
			if (coordinateReference!=null) {
				result = coordinateReference;
			}
			else {
				result = coordinateReference = PricingDataPointCoordinateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coordinate")
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder setCoordinate(PricingDataPointCoordinate coordinate) {
			this.coordinate = coordinate==null?null:coordinate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("coordinateReference")
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder setCoordinateReference(PricingDataPointCoordinateReference coordinateReference) {
			this.coordinateReference = coordinateReference==null?null:coordinateReference.toBuilder();
			return this;
		}
		
		@Override
		public PricingCoordinateOrReferenceModel build() {
			return new PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelImpl(this);
		}
		
		@Override
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder prune() {
			if (coordinate!=null && !coordinate.prune().hasData()) coordinate = null;
			if (coordinateReference!=null && !coordinateReference.prune().hasData()) coordinateReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCoordinate()!=null && getCoordinate().hasData()) return true;
			if (getCoordinateReference()!=null && getCoordinateReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder o = (PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder) other;
			
			merger.mergeRosetta(getCoordinate(), o.getCoordinate(), this::setCoordinate);
			merger.mergeRosetta(getCoordinateReference(), o.getCoordinateReference(), this::setCoordinateReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingCoordinateOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(coordinate, _that.getCoordinate())) return false;
			if (!Objects.equals(coordinateReference, _that.getCoordinateReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coordinate != null ? coordinate.hashCode() : 0);
			_result = 31 * _result + (coordinateReference != null ? coordinateReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingCoordinateOrReferenceModelBuilder {" +
				"coordinate=" + this.coordinate + ", " +
				"coordinateReference=" + this.coordinateReference +
			'}';
		}
	}
}
