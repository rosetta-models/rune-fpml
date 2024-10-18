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
import fpml.confirmation.BasicAssetValuation;
import fpml.confirmation.FxRateSet;
import fpml.confirmation.FxRateSet.FxRateSetBuilder;
import fpml.confirmation.FxRateSet.FxRateSetBuilderImpl;
import fpml.confirmation.FxRateSet.FxRateSetImpl;
import fpml.confirmation.InstrumentSet;
import fpml.confirmation.QuotedAssetSet;
import fpml.confirmation.QuotedAssetSet.QuotedAssetSetBuilder;
import fpml.confirmation.QuotedAssetSet.QuotedAssetSetBuilderImpl;
import fpml.confirmation.QuotedAssetSet.QuotedAssetSetImpl;
import fpml.confirmation.meta.FxRateSetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A collection of spot FX rates used in pricing.
 * @version ${project.version}
 */
@RosettaDataType(value="FxRateSet", builder=FxRateSet.FxRateSetBuilderImpl.class, version="${project.version}")
public interface FxRateSet extends QuotedAssetSet {

	FxRateSetMeta metaData = new FxRateSetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxRateSet build();
	
	FxRateSet.FxRateSetBuilder toBuilder();
	
	static FxRateSet.FxRateSetBuilder builder() {
		return new FxRateSet.FxRateSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateSet> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxRateSet> getType() {
		return FxRateSet.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instrumentSet"), processor, InstrumentSet.class, getInstrumentSet());
		processRosetta(path.newSubPath("assetQuote"), processor, BasicAssetValuation.class, getAssetQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateSetBuilder extends FxRateSet, QuotedAssetSet.QuotedAssetSetBuilder {
		FxRateSet.FxRateSetBuilder setInstrumentSet(InstrumentSet instrumentSet);
		FxRateSet.FxRateSetBuilder addAssetQuote(BasicAssetValuation assetQuote0);
		FxRateSet.FxRateSetBuilder addAssetQuote(BasicAssetValuation assetQuote1, int _idx);
		FxRateSet.FxRateSetBuilder addAssetQuote(List<? extends BasicAssetValuation> assetQuote2);
		FxRateSet.FxRateSetBuilder setAssetQuote(List<? extends BasicAssetValuation> assetQuote3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instrumentSet"), processor, InstrumentSet.InstrumentSetBuilder.class, getInstrumentSet());
			processRosetta(path.newSubPath("assetQuote"), processor, BasicAssetValuation.BasicAssetValuationBuilder.class, getAssetQuote());
		}
		

		FxRateSet.FxRateSetBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateSet  ***********************/
	class FxRateSetImpl extends QuotedAssetSet.QuotedAssetSetImpl implements FxRateSet {
		
		protected FxRateSetImpl(FxRateSet.FxRateSetBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxRateSet build() {
			return this;
		}
		
		@Override
		public FxRateSet.FxRateSetBuilder toBuilder() {
			FxRateSet.FxRateSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateSet.FxRateSetBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateSet {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxRateSet  ***********************/
	class FxRateSetBuilderImpl extends QuotedAssetSet.QuotedAssetSetBuilderImpl  implements FxRateSet.FxRateSetBuilder {
	
	
		public FxRateSetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("instrumentSet")
		public FxRateSet.FxRateSetBuilder setInstrumentSet(InstrumentSet instrumentSet) {
			this.instrumentSet = instrumentSet==null?null:instrumentSet.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetQuote")
		public FxRateSet.FxRateSetBuilder addAssetQuote(BasicAssetValuation assetQuote) {
			if (assetQuote!=null) this.assetQuote.add(assetQuote.toBuilder());
			return this;
		}
		
		@Override
		public FxRateSet.FxRateSetBuilder addAssetQuote(BasicAssetValuation assetQuote, int _idx) {
			getIndex(this.assetQuote, _idx, () -> assetQuote.toBuilder());
			return this;
		}
		@Override 
		public FxRateSet.FxRateSetBuilder addAssetQuote(List<? extends BasicAssetValuation> assetQuotes) {
			if (assetQuotes != null) {
				for (BasicAssetValuation toAdd : assetQuotes) {
					this.assetQuote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxRateSet.FxRateSetBuilder setAssetQuote(List<? extends BasicAssetValuation> assetQuotes) {
			if (assetQuotes == null)  {
				this.assetQuote = new ArrayList<>();
			}
			else {
				this.assetQuote = assetQuotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxRateSet build() {
			return new FxRateSet.FxRateSetImpl(this);
		}
		
		@Override
		public FxRateSet.FxRateSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateSet.FxRateSetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateSet.FxRateSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxRateSet.FxRateSetBuilder o = (FxRateSet.FxRateSetBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateSetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
