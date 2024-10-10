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
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ReturnSwapLegUnderlyer;
import fpml.confirmation.ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder;
import fpml.confirmation.ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl;
import fpml.confirmation.ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerImpl;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.ReturnSwapLegUnderlyerMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A base class for all return leg types with an underlyer.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwapLegUnderlyer", builder=ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl.class, version="${project.version}")
public interface ReturnSwapLegUnderlyer extends DirectionalLeg {

	ReturnSwapLegUnderlyerMeta metaData = new ReturnSwapLegUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the strike date of this leg of the swap, used for forward starting swaps. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically by relative to the trade date of the swap.
	 */
	AdjustableOrRelativeDate getStrikeDate();
	/**
	 * Specifies the underlying component of the leg, which can be either one or many and consists in either equity, index or convertible bond component, or a combination of these.
	 */
	Underlyer getUnderlyer();
	OptionSettlementModel getOptionSettlementModel();

	/*********************** Build Methods  ***********************/
	ReturnSwapLegUnderlyer build();
	
	ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder toBuilder();
	
	static ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder() {
		return new ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapLegUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapLegUnderlyer> getType() {
		return ReturnSwapLegUnderlyer.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.class, getStrikeDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.class, getOptionSettlementModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapLegUnderlyerBuilder extends ReturnSwapLegUnderlyer, DirectionalLeg.DirectionalLegBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDate();
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		Underlyer.UnderlyerBuilder getUnderlyer();
		OptionSettlementModel.OptionSettlementModelBuilder getOrCreateOptionSettlementModel();
		OptionSettlementModel.OptionSettlementModelBuilder getOptionSettlementModel();
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setId(String id);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setStrikeDate(AdjustableOrRelativeDate strikeDate);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setUnderlyer(Underlyer underlyer);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.OptionSettlementModelBuilder.class, getOptionSettlementModel());
		}
		

		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapLegUnderlyer  ***********************/
	class ReturnSwapLegUnderlyerImpl extends DirectionalLeg.DirectionalLegImpl implements ReturnSwapLegUnderlyer {
		private final AdjustableOrRelativeDate strikeDate;
		private final Underlyer underlyer;
		private final OptionSettlementModel optionSettlementModel;
		
		protected ReturnSwapLegUnderlyerImpl(ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder) {
			super(builder);
			this.strikeDate = ofNullable(builder.getStrikeDate()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.optionSettlementModel = ofNullable(builder.getOptionSettlementModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikeDate")
		public AdjustableOrRelativeDate getStrikeDate() {
			return strikeDate;
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
		public ReturnSwapLegUnderlyer build() {
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder toBuilder() {
			ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeDate()).ifPresent(builder::setStrikeDate);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getOptionSettlementModel()).ifPresent(builder::setOptionSettlementModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapLegUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(strikeDate, _that.getStrikeDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(optionSettlementModel, _that.getOptionSettlementModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeDate != null ? strikeDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (optionSettlementModel != null ? optionSettlementModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapLegUnderlyer {" +
				"strikeDate=" + this.strikeDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"optionSettlementModel=" + this.optionSettlementModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapLegUnderlyer  ***********************/
	class ReturnSwapLegUnderlyerBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl  implements ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder strikeDate;
		protected Underlyer.UnderlyerBuilder underlyer;
		protected OptionSettlementModel.OptionSettlementModelBuilder optionSettlementModel;
	
		public ReturnSwapLegUnderlyerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikeDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDate() {
			return strikeDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (strikeDate!=null) {
				result = strikeDate;
			}
			else {
				result = strikeDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
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
		@RosettaAttribute("id")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("legIdentifier")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeDate")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setStrikeDate(AdjustableOrRelativeDate strikeDate) {
			this.strikeDate = strikeDate==null?null:strikeDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer build() {
			return new ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerImpl(this);
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder prune() {
			super.prune();
			if (strikeDate!=null && !strikeDate.prune().hasData()) strikeDate = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (optionSettlementModel!=null && !optionSettlementModel.prune().hasData()) optionSettlementModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeDate()!=null && getStrikeDate().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getOptionSettlementModel()!=null && getOptionSettlementModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder o = (ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder) other;
			
			merger.mergeRosetta(getStrikeDate(), o.getStrikeDate(), this::setStrikeDate);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getOptionSettlementModel(), o.getOptionSettlementModel(), this::setOptionSettlementModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapLegUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(strikeDate, _that.getStrikeDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(optionSettlementModel, _that.getOptionSettlementModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeDate != null ? strikeDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (optionSettlementModel != null ? optionSettlementModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapLegUnderlyerBuilder {" +
				"strikeDate=" + this.strikeDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"optionSettlementModel=" + this.optionSettlementModel +
			'}' + " " + super.toString();
		}
	}
}
