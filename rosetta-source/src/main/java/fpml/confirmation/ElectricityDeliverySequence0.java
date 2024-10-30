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
import fpml.confirmation.ElectricityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySequence0;
import fpml.confirmation.ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder;
import fpml.confirmation.ElectricityDeliverySequence0.ElectricityDeliverySequence0BuilderImpl;
import fpml.confirmation.ElectricityDeliverySequence0.ElectricityDeliverySequence0Impl;
import fpml.confirmation.ElectricityDeliveryType;
import fpml.confirmation.ElectricityTransmissionContingency;
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.meta.ElectricityDeliverySequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ElectricityDeliverySequence0", builder=ElectricityDeliverySequence0.ElectricityDeliverySequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ElectricityDeliverySequence0 extends RosettaModelObject {

	ElectricityDeliverySequence0Meta metaData = new ElectricityDeliverySequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The point at which delivery of the electricity will occur.
	 */
	ElectricityDeliveryPoint getDeliveryPoint();
	/**
	 * Indicates the under what conditions the Parties&#39; delivery obligations apply.
	 */
	ElectricityDeliveryType getDeliveryType();
	/**
	 * Indicates that the performance of the buyer or seller shall be excused (under the conditions specified) if transmission of the elctricity is unavailable or interrupted.
	 */
	ElectricityTransmissionContingency getTransmissionContingency();
	/**
	 * Identification of the border(s) or border point(s) of a transportation contract.
	 */
	InterconnectionPoint getInterconnectionPoint();

	/*********************** Build Methods  ***********************/
	ElectricityDeliverySequence0 build();
	
	ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder toBuilder();
	
	static ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder builder() {
		return new ElectricityDeliverySequence0.ElectricityDeliverySequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliverySequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDeliverySequence0> getType() {
		return ElectricityDeliverySequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPoint"), processor, ElectricityDeliveryPoint.class, getDeliveryPoint());
		processRosetta(path.newSubPath("deliveryType"), processor, ElectricityDeliveryType.class, getDeliveryType());
		processRosetta(path.newSubPath("transmissionContingency"), processor, ElectricityTransmissionContingency.class, getTransmissionContingency());
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliverySequence0Builder extends ElectricityDeliverySequence0, RosettaModelObjectBuilder {
		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getOrCreateDeliveryPoint();
		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getDeliveryPoint();
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getOrCreateDeliveryType();
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getDeliveryType();
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getOrCreateTransmissionContingency();
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getTransmissionContingency();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setDeliveryPoint(ElectricityDeliveryPoint deliveryPoint);
		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setDeliveryType(ElectricityDeliveryType deliveryType);
		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setTransmissionContingency(ElectricityTransmissionContingency transmissionContingency);
		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPoint"), processor, ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder.class, getDeliveryPoint());
			processRosetta(path.newSubPath("deliveryType"), processor, ElectricityDeliveryType.ElectricityDeliveryTypeBuilder.class, getDeliveryType());
			processRosetta(path.newSubPath("transmissionContingency"), processor, ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder.class, getTransmissionContingency());
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
		}
		

		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliverySequence0  ***********************/
	class ElectricityDeliverySequence0Impl implements ElectricityDeliverySequence0 {
		private final ElectricityDeliveryPoint deliveryPoint;
		private final ElectricityDeliveryType deliveryType;
		private final ElectricityTransmissionContingency transmissionContingency;
		private final InterconnectionPoint interconnectionPoint;
		
		protected ElectricityDeliverySequence0Impl(ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder builder) {
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).map(f->f.build()).orElse(null);
			this.deliveryType = ofNullable(builder.getDeliveryType()).map(f->f.build()).orElse(null);
			this.transmissionContingency = ofNullable(builder.getTransmissionContingency()).map(f->f.build()).orElse(null);
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		public ElectricityDeliveryPoint getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		public ElectricityDeliveryType getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("transmissionContingency")
		public ElectricityTransmissionContingency getTransmissionContingency() {
			return transmissionContingency;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public ElectricityDeliverySequence0 build() {
			return this;
		}
		
		@Override
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder toBuilder() {
			ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder builder) {
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getTransmissionContingency()).ifPresent(builder::setTransmissionContingency);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySequence0 _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(transmissionContingency, _that.getTransmissionContingency())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.hashCode() : 0);
			_result = 31 * _result + (transmissionContingency != null ? transmissionContingency.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySequence0 {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"transmissionContingency=" + this.transmissionContingency + ", " +
				"interconnectionPoint=" + this.interconnectionPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliverySequence0  ***********************/
	class ElectricityDeliverySequence0BuilderImpl implements ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder {
	
		protected ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder deliveryPoint;
		protected ElectricityDeliveryType.ElectricityDeliveryTypeBuilder deliveryType;
		protected ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder transmissionContingency;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
	
		public ElectricityDeliverySequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryPoint")
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getOrCreateDeliveryPoint() {
			ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder result;
			if (deliveryPoint!=null) {
				result = deliveryPoint;
			}
			else {
				result = deliveryPoint = ElectricityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getOrCreateDeliveryType() {
			ElectricityDeliveryType.ElectricityDeliveryTypeBuilder result;
			if (deliveryType!=null) {
				result = deliveryType;
			}
			else {
				result = deliveryType = ElectricityDeliveryType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transmissionContingency")
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getTransmissionContingency() {
			return transmissionContingency;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getOrCreateTransmissionContingency() {
			ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder result;
			if (transmissionContingency!=null) {
				result = transmissionContingency;
			}
			else {
				result = transmissionContingency = ElectricityTransmissionContingency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setDeliveryPoint(ElectricityDeliveryPoint deliveryPoint) {
			this.deliveryPoint = deliveryPoint==null?null:deliveryPoint.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryType")
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setDeliveryType(ElectricityDeliveryType deliveryType) {
			this.deliveryType = deliveryType==null?null:deliveryType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transmissionContingency")
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setTransmissionContingency(ElectricityTransmissionContingency transmissionContingency) {
			this.transmissionContingency = transmissionContingency==null?null:transmissionContingency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interconnectionPoint")
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder setInterconnectionPoint(InterconnectionPoint interconnectionPoint) {
			this.interconnectionPoint = interconnectionPoint==null?null:interconnectionPoint.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliverySequence0 build() {
			return new ElectricityDeliverySequence0.ElectricityDeliverySequence0Impl(this);
		}
		
		@Override
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder prune() {
			if (deliveryPoint!=null && !deliveryPoint.prune().hasData()) deliveryPoint = null;
			if (deliveryType!=null && !deliveryType.prune().hasData()) deliveryType = null;
			if (transmissionContingency!=null && !transmissionContingency.prune().hasData()) transmissionContingency = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPoint()!=null && getDeliveryPoint().hasData()) return true;
			if (getDeliveryType()!=null && getDeliveryType().hasData()) return true;
			if (getTransmissionContingency()!=null && getTransmissionContingency().hasData()) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder o = (ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder) other;
			
			merger.mergeRosetta(getDeliveryPoint(), o.getDeliveryPoint(), this::setDeliveryPoint);
			merger.mergeRosetta(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeRosetta(getTransmissionContingency(), o.getTransmissionContingency(), this::setTransmissionContingency);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySequence0 _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(transmissionContingency, _that.getTransmissionContingency())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.hashCode() : 0);
			_result = 31 * _result + (transmissionContingency != null ? transmissionContingency.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySequence0Builder {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"transmissionContingency=" + this.transmissionContingency + ", " +
				"interconnectionPoint=" + this.interconnectionPoint +
			'}';
		}
	}
}
