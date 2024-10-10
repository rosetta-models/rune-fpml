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
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.CorrelationLeg;
import fpml.confirmation.CorrelationSwap;
import fpml.confirmation.CorrelationSwap.CorrelationSwapBuilder;
import fpml.confirmation.CorrelationSwap.CorrelationSwapBuilderImpl;
import fpml.confirmation.CorrelationSwap.CorrelationSwapImpl;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.NettedSwapBase;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilder;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilderImpl;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CorrelationSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of a correlation swap. A Correlation Swap modelled using a single netted leg.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationSwap", builder=CorrelationSwap.CorrelationSwapBuilderImpl.class, version="${project.version}")
public interface CorrelationSwap extends NettedSwapBase {

	CorrelationSwapMeta metaData = new CorrelationSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Correlation Leg. Correlation Buyer is deemed to be the Equity Amount Receiver, Correlation Seller is deemed to be the Equity Amount Payer.
	 */
	CorrelationLeg getCorrelationLeg();

	/*********************** Build Methods  ***********************/
	CorrelationSwap build();
	
	CorrelationSwap.CorrelationSwapBuilder toBuilder();
	
	static CorrelationSwap.CorrelationSwapBuilder builder() {
		return new CorrelationSwap.CorrelationSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationSwap> getType() {
		return CorrelationSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("correlationLeg"), processor, CorrelationLeg.class, getCorrelationLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationSwapBuilder extends CorrelationSwap, NettedSwapBase.NettedSwapBaseBuilder {
		CorrelationLeg.CorrelationLegBuilder getOrCreateCorrelationLeg();
		CorrelationLeg.CorrelationLegBuilder getCorrelationLeg();
		CorrelationSwap.CorrelationSwapBuilder setProductModel(ProductModel productModel);
		CorrelationSwap.CorrelationSwapBuilder setId(String id);
		CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment0);
		CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment1, int _idx);
		CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment2);
		CorrelationSwap.CorrelationSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment3);
		CorrelationSwap.CorrelationSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		CorrelationSwap.CorrelationSwapBuilder setCorrelationLeg(CorrelationLeg correlationLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.ClassifiablePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("correlationLeg"), processor, CorrelationLeg.CorrelationLegBuilder.class, getCorrelationLeg());
		}
		

		CorrelationSwap.CorrelationSwapBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationSwap  ***********************/
	class CorrelationSwapImpl extends NettedSwapBase.NettedSwapBaseImpl implements CorrelationSwap {
		private final CorrelationLeg correlationLeg;
		
		protected CorrelationSwapImpl(CorrelationSwap.CorrelationSwapBuilder builder) {
			super(builder);
			this.correlationLeg = ofNullable(builder.getCorrelationLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationLeg")
		public CorrelationLeg getCorrelationLeg() {
			return correlationLeg;
		}
		
		@Override
		public CorrelationSwap build() {
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder toBuilder() {
			CorrelationSwap.CorrelationSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationSwap.CorrelationSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCorrelationLeg()).ifPresent(builder::setCorrelationLeg);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationSwap _that = getType().cast(o);
		
			if (!Objects.equals(correlationLeg, _that.getCorrelationLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationLeg != null ? correlationLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationSwap {" +
				"correlationLeg=" + this.correlationLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationSwap  ***********************/
	class CorrelationSwapBuilderImpl extends NettedSwapBase.NettedSwapBaseBuilderImpl  implements CorrelationSwap.CorrelationSwapBuilder {
	
		protected CorrelationLeg.CorrelationLegBuilder correlationLeg;
	
		public CorrelationSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("correlationLeg")
		public CorrelationLeg.CorrelationLegBuilder getCorrelationLeg() {
			return correlationLeg;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder getOrCreateCorrelationLeg() {
			CorrelationLeg.CorrelationLegBuilder result;
			if (correlationLeg!=null) {
				result = correlationLeg;
			}
			else {
				result = correlationLeg = CorrelationLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CorrelationSwap.CorrelationSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CorrelationSwap.CorrelationSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public CorrelationSwap.CorrelationSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ClassifiablePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public CorrelationSwap.CorrelationSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public CorrelationSwap.CorrelationSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationLeg")
		public CorrelationSwap.CorrelationSwapBuilder setCorrelationLeg(CorrelationLeg correlationLeg) {
			this.correlationLeg = correlationLeg==null?null:correlationLeg.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationSwap build() {
			return new CorrelationSwap.CorrelationSwapImpl(this);
		}
		
		@Override
		public CorrelationSwap.CorrelationSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder prune() {
			super.prune();
			if (correlationLeg!=null && !correlationLeg.prune().hasData()) correlationLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCorrelationLeg()!=null && getCorrelationLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationSwap.CorrelationSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CorrelationSwap.CorrelationSwapBuilder o = (CorrelationSwap.CorrelationSwapBuilder) other;
			
			merger.mergeRosetta(getCorrelationLeg(), o.getCorrelationLeg(), this::setCorrelationLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationSwap _that = getType().cast(o);
		
			if (!Objects.equals(correlationLeg, _that.getCorrelationLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationLeg != null ? correlationLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationSwapBuilder {" +
				"correlationLeg=" + this.correlationLeg +
			'}' + " " + super.toString();
		}
	}
}
