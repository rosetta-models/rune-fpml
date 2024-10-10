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
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySequence1;
import fpml.confirmation.ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder;
import fpml.confirmation.ElectricityDeliverySequence1.ElectricityDeliverySequence1BuilderImpl;
import fpml.confirmation.ElectricityDeliverySequence1.ElectricityDeliverySequence1Impl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.ElectricityDeliverySequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityDeliverySequence1", builder=ElectricityDeliverySequence1.ElectricityDeliverySequence1BuilderImpl.class, version="${project.version}")
public interface ElectricityDeliverySequence1 extends RosettaModelObject {

	ElectricityDeliverySequence1Meta metaData = new ElectricityDeliverySequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The zone covering potential delivery points for the electricity.
	 */
	CommodityDeliveryPoint getDeliveryZone();
	/**
	 * Indicates the party able to decide which delivery point within the deliveryPoint is used for delivery. For EEI transactions, this should reference the seller of the electricity.
	 */
	PartyReference getElectingPartyReference();

	/*********************** Build Methods  ***********************/
	ElectricityDeliverySequence1 build();
	
	ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder toBuilder();
	
	static ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder builder() {
		return new ElectricityDeliverySequence1.ElectricityDeliverySequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliverySequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDeliverySequence1> getType() {
		return ElectricityDeliverySequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryZone"), processor, CommodityDeliveryPoint.class, getDeliveryZone());
		processRosetta(path.newSubPath("electingPartyReference"), processor, PartyReference.class, getElectingPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliverySequence1Builder extends ElectricityDeliverySequence1, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryZone();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryZone();
		PartyReference.PartyReferenceBuilder getOrCreateElectingPartyReference();
		PartyReference.PartyReferenceBuilder getElectingPartyReference();
		ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder setDeliveryZone(CommodityDeliveryPoint deliveryZone);
		ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder setElectingPartyReference(PartyReference electingPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryZone"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getDeliveryZone());
			processRosetta(path.newSubPath("electingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getElectingPartyReference());
		}
		

		ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliverySequence1  ***********************/
	class ElectricityDeliverySequence1Impl implements ElectricityDeliverySequence1 {
		private final CommodityDeliveryPoint deliveryZone;
		private final PartyReference electingPartyReference;
		
		protected ElectricityDeliverySequence1Impl(ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder builder) {
			this.deliveryZone = ofNullable(builder.getDeliveryZone()).map(f->f.build()).orElse(null);
			this.electingPartyReference = ofNullable(builder.getElectingPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryZone")
		public CommodityDeliveryPoint getDeliveryZone() {
			return deliveryZone;
		}
		
		@Override
		@RosettaAttribute("electingPartyReference")
		public PartyReference getElectingPartyReference() {
			return electingPartyReference;
		}
		
		@Override
		public ElectricityDeliverySequence1 build() {
			return this;
		}
		
		@Override
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder toBuilder() {
			ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder builder) {
			ofNullable(getDeliveryZone()).ifPresent(builder::setDeliveryZone);
			ofNullable(getElectingPartyReference()).ifPresent(builder::setElectingPartyReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySequence1 _that = getType().cast(o);
		
			if (!Objects.equals(deliveryZone, _that.getDeliveryZone())) return false;
			if (!Objects.equals(electingPartyReference, _that.getElectingPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryZone != null ? deliveryZone.hashCode() : 0);
			_result = 31 * _result + (electingPartyReference != null ? electingPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySequence1 {" +
				"deliveryZone=" + this.deliveryZone + ", " +
				"electingPartyReference=" + this.electingPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliverySequence1  ***********************/
	class ElectricityDeliverySequence1BuilderImpl implements ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder {
	
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder deliveryZone;
		protected PartyReference.PartyReferenceBuilder electingPartyReference;
	
		public ElectricityDeliverySequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryZone")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryZone() {
			return deliveryZone;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryZone() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (deliveryZone!=null) {
				result = deliveryZone;
			}
			else {
				result = deliveryZone = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("electingPartyReference")
		public PartyReference.PartyReferenceBuilder getElectingPartyReference() {
			return electingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateElectingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (electingPartyReference!=null) {
				result = electingPartyReference;
			}
			else {
				result = electingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryZone")
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder setDeliveryZone(CommodityDeliveryPoint deliveryZone) {
			this.deliveryZone = deliveryZone==null?null:deliveryZone.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("electingPartyReference")
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder setElectingPartyReference(PartyReference electingPartyReference) {
			this.electingPartyReference = electingPartyReference==null?null:electingPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliverySequence1 build() {
			return new ElectricityDeliverySequence1.ElectricityDeliverySequence1Impl(this);
		}
		
		@Override
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder prune() {
			if (deliveryZone!=null && !deliveryZone.prune().hasData()) deliveryZone = null;
			if (electingPartyReference!=null && !electingPartyReference.prune().hasData()) electingPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryZone()!=null && getDeliveryZone().hasData()) return true;
			if (getElectingPartyReference()!=null && getElectingPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder o = (ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder) other;
			
			merger.mergeRosetta(getDeliveryZone(), o.getDeliveryZone(), this::setDeliveryZone);
			merger.mergeRosetta(getElectingPartyReference(), o.getElectingPartyReference(), this::setElectingPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySequence1 _that = getType().cast(o);
		
			if (!Objects.equals(deliveryZone, _that.getDeliveryZone())) return false;
			if (!Objects.equals(electingPartyReference, _that.getElectingPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryZone != null ? deliveryZone.hashCode() : 0);
			_result = 31 * _result + (electingPartyReference != null ? electingPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySequence1Builder {" +
				"deliveryZone=" + this.deliveryZone + ", " +
				"electingPartyReference=" + this.electingPartyReference +
			'}';
		}
	}
}
