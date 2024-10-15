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
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanAllocationIdentifier.LoanAllocationIdentifierBuilder;
import fpml.confirmation.LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl;
import fpml.confirmation.LoanAllocationIdentifier.LoanAllocationIdentifierImpl;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilder;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilderImpl;
import fpml.confirmation.TradeIdentifier.TradeIdentifierImpl;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.meta.LoanAllocationIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that contains sender-specific and optional shared loan allocation identifiers.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationIdentifier", builder=LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl.class, version="${project.version}")
public interface LoanAllocationIdentifier extends TradeIdentifier {

	LoanAllocationIdentifierMeta metaData = new LoanAllocationIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the original loan trade.
	 */
	LoanTradeReference getLoanTradeReference();

	/*********************** Build Methods  ***********************/
	LoanAllocationIdentifier build();
	
	LoanAllocationIdentifier.LoanAllocationIdentifierBuilder toBuilder();
	
	static LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder() {
		return new LoanAllocationIdentifier.LoanAllocationIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationIdentifier> getType() {
		return LoanAllocationIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.class, getIssuerTradeIdModel());
		processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.class, getTradeIdentifierSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationIdentifierBuilder extends LoanAllocationIdentifier, TradeIdentifier.TradeIdentifierBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel);
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence);
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setId(String id);
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.IssuerTradeIdModelBuilder.class, getIssuerTradeIdModel());
			processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.TradeIdentifierSequenceBuilder.class, getTradeIdentifierSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
		}
		

		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationIdentifier  ***********************/
	class LoanAllocationIdentifierImpl extends TradeIdentifier.TradeIdentifierImpl implements LoanAllocationIdentifier {
		private final LoanTradeReference loanTradeReference;
		
		protected LoanAllocationIdentifierImpl(LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanAllocationIdentifier build() {
			return this;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder toBuilder() {
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationIdentifier.LoanAllocationIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationIdentifier {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationIdentifier  ***********************/
	class LoanAllocationIdentifierBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl  implements LoanAllocationIdentifier.LoanAllocationIdentifierBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
	
		public LoanAllocationIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel) {
			this.issuerTradeIdModel = issuerTradeIdModel==null?null:issuerTradeIdModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifierSequence")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence) {
			this.tradeIdentifierSequence = tradeIdentifierSequence==null?null:tradeIdentifierSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationIdentifier build() {
			return new LoanAllocationIdentifier.LoanAllocationIdentifierImpl(this);
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder prune() {
			super.prune();
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder o = (LoanAllocationIdentifier.LoanAllocationIdentifierBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationIdentifierBuilder {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}
}
