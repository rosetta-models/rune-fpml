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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilder;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilderImpl;
import fpml.confirmation.DirectionalLeg.DirectionalLegImpl;
import fpml.confirmation.DirectionalLegUnderlyer;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl;
import fpml.confirmation.FxFeature;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.DirectionalLegUnderlyerMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for all directional leg types with effective date, termination date, and underlyer where a payer makes a stream of payments of greater than zero value to a receiver.
 * @version ${project.version}
 */
@RosettaDataType(value="DirectionalLegUnderlyer", builder=DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl.class, version="${project.version}")
public interface DirectionalLegUnderlyer extends DirectionalLeg {

	DirectionalLegUnderlyerMeta metaData = new DirectionalLegUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the underlyer of the leg.
	 */
	Underlyer getUnderlyer();
	OptionSettlementModel getOptionSettlementModel();
	/**
	 * Quanto, Composite, or Cross Currency FX features.
	 */
	FxFeature getFxFeature();

	/*********************** Build Methods  ***********************/
	DirectionalLegUnderlyer build();
	
	DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder toBuilder();
	
	static DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder builder() {
		return new DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DirectionalLegUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DirectionalLegUnderlyer> getType() {
		return DirectionalLegUnderlyer.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.class, getOptionSettlementModel());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DirectionalLegUnderlyerBuilder extends DirectionalLegUnderlyer, DirectionalLeg.DirectionalLegBuilder {
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		Underlyer.UnderlyerBuilder getUnderlyer();
		OptionSettlementModel.OptionSettlementModelBuilder getOrCreateOptionSettlementModel();
		OptionSettlementModel.OptionSettlementModelBuilder getOptionSettlementModel();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setId(String id);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setUnderlyer(Underlyer underlyer);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setFxFeature(FxFeature fxFeature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.OptionSettlementModelBuilder.class, getOptionSettlementModel());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
		}
		

		DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of DirectionalLegUnderlyer  ***********************/
	class DirectionalLegUnderlyerImpl extends DirectionalLeg.DirectionalLegImpl implements DirectionalLegUnderlyer {
		private final Underlyer underlyer;
		private final OptionSettlementModel optionSettlementModel;
		private final FxFeature fxFeature;
		
		protected DirectionalLegUnderlyerImpl(DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder builder) {
			super(builder);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.optionSettlementModel = ofNullable(builder.getOptionSettlementModel()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public Underlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("optionSettlementModel")
		public OptionSettlementModel getOptionSettlementModel() {
			return optionSettlementModel;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public DirectionalLegUnderlyer build() {
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder toBuilder() {
			DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getOptionSettlementModel()).ifPresent(builder::setOptionSettlementModel);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLegUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(optionSettlementModel, _that.getOptionSettlementModel())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (optionSettlementModel != null ? optionSettlementModel.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegUnderlyer {" +
				"underlyer=" + this.underlyer + ", " +
				"optionSettlementModel=" + this.optionSettlementModel + ", " +
				"fxFeature=" + this.fxFeature +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DirectionalLegUnderlyer  ***********************/
	class DirectionalLegUnderlyerBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl  implements DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder {
	
		protected Underlyer.UnderlyerBuilder underlyer;
		protected OptionSettlementModel.OptionSettlementModelBuilder optionSettlementModel;
		protected FxFeature.FxFeatureBuilder fxFeature;
	
		public DirectionalLegUnderlyerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlyer")
		public Underlyer.UnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateUnderlyer() {
			Underlyer.UnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = Underlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionSettlementModel")
		public OptionSettlementModel.OptionSettlementModelBuilder getOptionSettlementModel() {
			return optionSettlementModel;
		}
		
		@Override
		public OptionSettlementModel.OptionSettlementModelBuilder getOrCreateOptionSettlementModel() {
			OptionSettlementModel.OptionSettlementModelBuilder result;
			if (optionSettlementModel!=null) {
				result = optionSettlementModel;
			}
			else {
				result = optionSettlementModel = OptionSettlementModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null)  {
				this.legIdentifier = new ArrayList<>();
			}
			else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyer build() {
			return new DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl(this);
		}
		
		@Override
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder prune() {
			super.prune();
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (optionSettlementModel!=null && !optionSettlementModel.prune().hasData()) optionSettlementModel = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getOptionSettlementModel()!=null && getOptionSettlementModel().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder o = (DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder) other;
			
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getOptionSettlementModel(), o.getOptionSettlementModel(), this::setOptionSettlementModel);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLegUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(optionSettlementModel, _that.getOptionSettlementModel())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (optionSettlementModel != null ? optionSettlementModel.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegUnderlyerBuilder {" +
				"underlyer=" + this.underlyer + ", " +
				"optionSettlementModel=" + this.optionSettlementModel + ", " +
				"fxFeature=" + this.fxFeature +
			'}' + " " + super.toString();
		}
	}
}
