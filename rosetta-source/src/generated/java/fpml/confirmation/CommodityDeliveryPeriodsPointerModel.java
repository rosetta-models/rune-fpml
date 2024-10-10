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
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilderImpl;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelImpl;
import fpml.confirmation.meta.CommodityDeliveryPeriodsPointerModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Model group to enable users to reference a Delivery Periods schedule in the form of a series of actual dates in a deliveryPeriods container or in the form of a parameterised schedule in a deliveryPeriodsSchedule container.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDeliveryPeriodsPointerModel", builder=CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilderImpl.class, version="${project.version}")
public interface CommodityDeliveryPeriodsPointerModel extends RosettaModelObject {

	CommodityDeliveryPeriodsPointerModelMeta metaData = new CommodityDeliveryPeriodsPointerModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the Delivery Periods defined elsewhere.
	 */
	CalculationPeriodsReference getDeliveryPeriodsReference();
	/**
	 * A pointer style reference to the Calculation Periods Schedule defined elsewhere.
	 */
	CalculationPeriodsScheduleReference getDeliveryPeriodsScheduleReference();

	/*********************** Build Methods  ***********************/
	CommodityDeliveryPeriodsPointerModel build();
	
	CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder toBuilder();
	
	static CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder builder() {
		return new CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDeliveryPeriodsPointerModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDeliveryPeriodsPointerModel> getType() {
		return CommodityDeliveryPeriodsPointerModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.class, getDeliveryPeriodsReference());
		processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getDeliveryPeriodsScheduleReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDeliveryPeriodsPointerModelBuilder extends CommodityDeliveryPeriodsPointerModel, RosettaModelObjectBuilder {
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference();
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder setDeliveryPeriodsReference(CalculationPeriodsReference deliveryPeriodsReference);
		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getDeliveryPeriodsReference());
			processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getDeliveryPeriodsScheduleReference());
		}
		

		CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDeliveryPeriodsPointerModel  ***********************/
	class CommodityDeliveryPeriodsPointerModelImpl implements CommodityDeliveryPeriodsPointerModel {
		private final CalculationPeriodsReference deliveryPeriodsReference;
		private final CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference;
		
		protected CommodityDeliveryPeriodsPointerModelImpl(CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder builder) {
			this.deliveryPeriodsReference = ofNullable(builder.getDeliveryPeriodsReference()).map(f->f.build()).orElse(null);
			this.deliveryPeriodsScheduleReference = ofNullable(builder.getDeliveryPeriodsScheduleReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		public CalculationPeriodsReference getDeliveryPeriodsReference() {
			return deliveryPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getDeliveryPeriodsScheduleReference() {
			return deliveryPeriodsScheduleReference;
		}
		
		@Override
		public CommodityDeliveryPeriodsPointerModel build() {
			return this;
		}
		
		@Override
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder toBuilder() {
			CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder builder) {
			ofNullable(getDeliveryPeriodsReference()).ifPresent(builder::setDeliveryPeriodsReference);
			ofNullable(getDeliveryPeriodsScheduleReference()).ifPresent(builder::setDeliveryPeriodsScheduleReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPeriodsPointerModel _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPeriodsPointerModel {" +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDeliveryPeriodsPointerModel  ***********************/
	class CommodityDeliveryPeriodsPointerModelBuilderImpl implements CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder {
	
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder deliveryPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder deliveryPeriodsScheduleReference;
	
		public CommodityDeliveryPeriodsPointerModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference() {
			return deliveryPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (deliveryPeriodsReference!=null) {
				result = deliveryPeriodsReference;
			}
			else {
				result = deliveryPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference() {
			return deliveryPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (deliveryPeriodsScheduleReference!=null) {
				result = deliveryPeriodsScheduleReference;
			}
			else {
				result = deliveryPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder setDeliveryPeriodsReference(CalculationPeriodsReference deliveryPeriodsReference) {
			this.deliveryPeriodsReference = deliveryPeriodsReference==null?null:deliveryPeriodsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference) {
			this.deliveryPeriodsScheduleReference = deliveryPeriodsScheduleReference==null?null:deliveryPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDeliveryPeriodsPointerModel build() {
			return new CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelImpl(this);
		}
		
		@Override
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder prune() {
			if (deliveryPeriodsReference!=null && !deliveryPeriodsReference.prune().hasData()) deliveryPeriodsReference = null;
			if (deliveryPeriodsScheduleReference!=null && !deliveryPeriodsScheduleReference.prune().hasData()) deliveryPeriodsScheduleReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPeriodsReference()!=null && getDeliveryPeriodsReference().hasData()) return true;
			if (getDeliveryPeriodsScheduleReference()!=null && getDeliveryPeriodsScheduleReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder o = (CommodityDeliveryPeriodsPointerModel.CommodityDeliveryPeriodsPointerModelBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriodsReference(), o.getDeliveryPeriodsReference(), this::setDeliveryPeriodsReference);
			merger.mergeRosetta(getDeliveryPeriodsScheduleReference(), o.getDeliveryPeriodsScheduleReference(), this::setDeliveryPeriodsScheduleReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDeliveryPeriodsPointerModel _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDeliveryPeriodsPointerModelBuilder {" +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}
}
