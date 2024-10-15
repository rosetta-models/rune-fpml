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
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.NettedSwapBase;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilder;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilderImpl;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VarianceLeg;
import fpml.confirmation.VarianceSwap;
import fpml.confirmation.VarianceSwap.VarianceSwapBuilder;
import fpml.confirmation.VarianceSwap.VarianceSwapBuilderImpl;
import fpml.confirmation.VarianceSwap.VarianceSwapImpl;
import fpml.confirmation.meta.VarianceSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of a variance swap. A Variance Swap.
 * @version ${project.version}
 */
@RosettaDataType(value="VarianceSwap", builder=VarianceSwap.VarianceSwapBuilderImpl.class, version="${project.version}")
public interface VarianceSwap extends NettedSwapBase {

	VarianceSwapMeta metaData = new VarianceSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Variance Leg.
	 */
	List<? extends VarianceLeg> getVarianceLeg();

	/*********************** Build Methods  ***********************/
	VarianceSwap build();
	
	VarianceSwap.VarianceSwapBuilder toBuilder();
	
	static VarianceSwap.VarianceSwapBuilder builder() {
		return new VarianceSwap.VarianceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VarianceSwap> getType() {
		return VarianceSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("varianceLeg"), processor, VarianceLeg.class, getVarianceLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceSwapBuilder extends VarianceSwap, NettedSwapBase.NettedSwapBaseBuilder {
		VarianceLeg.VarianceLegBuilder getOrCreateVarianceLeg(int _index);
		List<? extends VarianceLeg.VarianceLegBuilder> getVarianceLeg();
		VarianceSwap.VarianceSwapBuilder setProductModel(ProductModel productModel);
		VarianceSwap.VarianceSwapBuilder setId(String id);
		VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment0);
		VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment1, int _idx);
		VarianceSwap.VarianceSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment2);
		VarianceSwap.VarianceSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment3);
		VarianceSwap.VarianceSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg varianceLeg0);
		VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg varianceLeg1, int _idx);
		VarianceSwap.VarianceSwapBuilder addVarianceLeg(List<? extends VarianceLeg> varianceLeg2);
		VarianceSwap.VarianceSwapBuilder setVarianceLeg(List<? extends VarianceLeg> varianceLeg3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.ClassifiablePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("varianceLeg"), processor, VarianceLeg.VarianceLegBuilder.class, getVarianceLeg());
		}
		

		VarianceSwap.VarianceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceSwap  ***********************/
	class VarianceSwapImpl extends NettedSwapBase.NettedSwapBaseImpl implements VarianceSwap {
		private final List<? extends VarianceLeg> varianceLeg;
		
		protected VarianceSwapImpl(VarianceSwap.VarianceSwapBuilder builder) {
			super(builder);
			this.varianceLeg = ofNullable(builder.getVarianceLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("varianceLeg")
		public List<? extends VarianceLeg> getVarianceLeg() {
			return varianceLeg;
		}
		
		@Override
		public VarianceSwap build() {
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder toBuilder() {
			VarianceSwap.VarianceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceSwap.VarianceSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVarianceLeg()).ifPresent(builder::setVarianceLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(varianceLeg, _that.getVarianceLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceLeg != null ? varianceLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceSwap {" +
				"varianceLeg=" + this.varianceLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceSwap  ***********************/
	class VarianceSwapBuilderImpl extends NettedSwapBase.NettedSwapBaseBuilderImpl  implements VarianceSwap.VarianceSwapBuilder {
	
		protected List<VarianceLeg.VarianceLegBuilder> varianceLeg = new ArrayList<>();
	
		public VarianceSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("varianceLeg")
		public List<? extends VarianceLeg.VarianceLegBuilder> getVarianceLeg() {
			return varianceLeg;
		}
		
		public VarianceLeg.VarianceLegBuilder getOrCreateVarianceLeg(int _index) {
		
			if (varianceLeg==null) {
				this.varianceLeg = new ArrayList<>();
			}
			VarianceLeg.VarianceLegBuilder result;
			return getIndex(varianceLeg, _index, () -> {
						VarianceLeg.VarianceLegBuilder newVarianceLeg = VarianceLeg.builder();
						return newVarianceLeg;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public VarianceSwap.VarianceSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VarianceSwap.VarianceSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public VarianceSwap.VarianceSwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ClassifiablePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public VarianceSwap.VarianceSwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		public VarianceSwap.VarianceSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		@Override
		public VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg varianceLeg) {
			if (varianceLeg!=null) this.varianceLeg.add(varianceLeg.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder addVarianceLeg(VarianceLeg varianceLeg, int _idx) {
			getIndex(this.varianceLeg, _idx, () -> varianceLeg.toBuilder());
			return this;
		}
		@Override 
		public VarianceSwap.VarianceSwapBuilder addVarianceLeg(List<? extends VarianceLeg> varianceLegs) {
			if (varianceLegs != null) {
				for (VarianceLeg toAdd : varianceLegs) {
					this.varianceLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("varianceLeg")
		public VarianceSwap.VarianceSwapBuilder setVarianceLeg(List<? extends VarianceLeg> varianceLegs) {
			if (varianceLegs == null)  {
				this.varianceLeg = new ArrayList<>();
			}
			else {
				this.varianceLeg = varianceLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public VarianceSwap build() {
			return new VarianceSwap.VarianceSwapImpl(this);
		}
		
		@Override
		public VarianceSwap.VarianceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceSwap.VarianceSwapBuilder prune() {
			super.prune();
			varianceLeg = varianceLeg.stream().filter(b->b!=null).<VarianceLeg.VarianceLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVarianceLeg()!=null && getVarianceLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceSwap.VarianceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VarianceSwap.VarianceSwapBuilder o = (VarianceSwap.VarianceSwapBuilder) other;
			
			merger.mergeRosetta(getVarianceLeg(), o.getVarianceLeg(), this::getOrCreateVarianceLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(varianceLeg, _that.getVarianceLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceLeg != null ? varianceLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceSwapBuilder {" +
				"varianceLeg=" + this.varianceLeg +
			'}' + " " + super.toString();
		}
	}
}
