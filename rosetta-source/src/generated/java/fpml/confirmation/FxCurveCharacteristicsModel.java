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
import fpml.confirmation.FxCurveCharacteristicsModel;
import fpml.confirmation.FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder;
import fpml.confirmation.FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilderImpl;
import fpml.confirmation.FxCurveCharacteristicsModel.FxCurveCharacteristicsModelImpl;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxCurveCharacteristicsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The set of characterstics that describe the outputs of a fx curve.
 * @version ${project.version}
 */
@RosettaDataType(value="FxCurveCharacteristicsModel", builder=FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilderImpl.class, version="${project.version}")
public interface FxCurveCharacteristicsModel extends RosettaModelObject {

	FxCurveCharacteristicsModelMeta metaData = new FxCurveCharacteristicsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();

	/*********************** Build Methods  ***********************/
	FxCurveCharacteristicsModel build();
	
	FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder toBuilder();
	
	static FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder builder() {
		return new FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCurveCharacteristicsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCurveCharacteristicsModel> getType() {
		return FxCurveCharacteristicsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCurveCharacteristicsModelBuilder extends FxCurveCharacteristicsModel, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
		}
		

		FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxCurveCharacteristicsModel  ***********************/
	class FxCurveCharacteristicsModelImpl implements FxCurveCharacteristicsModel {
		private final QuotedCurrencyPair quotedCurrencyPair;
		
		protected FxCurveCharacteristicsModelImpl(FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public FxCurveCharacteristicsModel build() {
			return this;
		}
		
		@Override
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder toBuilder() {
			FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCurveCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveCharacteristicsModel {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCurveCharacteristicsModel  ***********************/
	class FxCurveCharacteristicsModelBuilderImpl implements FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
	
		public FxCurveCharacteristicsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@Override
		public FxCurveCharacteristicsModel build() {
			return new FxCurveCharacteristicsModel.FxCurveCharacteristicsModelImpl(this);
		}
		
		@Override
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder o = (FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCurveCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveCharacteristicsModelBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair +
			'}';
		}
	}
}
