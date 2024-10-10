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
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilder;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilderImpl;
import fpml.confirmation.TradeIdentifier.TradeIdentifierImpl;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.meta.TradeIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a trade identifier issued by the indicated party.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeIdentifier", builder=TradeIdentifier.TradeIdentifierBuilderImpl.class, version="${project.version}")
public interface TradeIdentifier extends RosettaModelObject {

	TradeIdentifierMeta metaData = new TradeIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	IssuerTradeIdModel getIssuerTradeIdModel();
	TradeIdentifierSequence getTradeIdentifierSequence();
	String getId();

	/*********************** Build Methods  ***********************/
	TradeIdentifier build();
	
	TradeIdentifier.TradeIdentifierBuilder toBuilder();
	
	static TradeIdentifier.TradeIdentifierBuilder builder() {
		return new TradeIdentifier.TradeIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeIdentifier> getType() {
		return TradeIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.class, getIssuerTradeIdModel());
		processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.class, getTradeIdentifierSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierBuilder extends TradeIdentifier, RosettaModelObjectBuilder {
		IssuerTradeIdModel.IssuerTradeIdModelBuilder getOrCreateIssuerTradeIdModel();
		IssuerTradeIdModel.IssuerTradeIdModelBuilder getIssuerTradeIdModel();
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder getOrCreateTradeIdentifierSequence();
		TradeIdentifierSequence.TradeIdentifierSequenceBuilder getTradeIdentifierSequence();
		TradeIdentifier.TradeIdentifierBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel);
		TradeIdentifier.TradeIdentifierBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence);
		TradeIdentifier.TradeIdentifierBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.IssuerTradeIdModelBuilder.class, getIssuerTradeIdModel());
			processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.TradeIdentifierSequenceBuilder.class, getTradeIdentifierSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		TradeIdentifier.TradeIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifier  ***********************/
	class TradeIdentifierImpl implements TradeIdentifier {
		private final IssuerTradeIdModel issuerTradeIdModel;
		private final TradeIdentifierSequence tradeIdentifierSequence;
		private final String id;
		
		protected TradeIdentifierImpl(TradeIdentifier.TradeIdentifierBuilder builder) {
			this.issuerTradeIdModel = ofNullable(builder.getIssuerTradeIdModel()).map(f->f.build()).orElse(null);
			this.tradeIdentifierSequence = ofNullable(builder.getTradeIdentifierSequence()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public IssuerTradeIdModel getIssuerTradeIdModel() {
			return issuerTradeIdModel;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierSequence")
		public TradeIdentifierSequence getTradeIdentifierSequence() {
			return tradeIdentifierSequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public TradeIdentifier build() {
			return this;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder toBuilder() {
			TradeIdentifier.TradeIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifier.TradeIdentifierBuilder builder) {
			ofNullable(getIssuerTradeIdModel()).ifPresent(builder::setIssuerTradeIdModel);
			ofNullable(getTradeIdentifierSequence()).ifPresent(builder::setTradeIdentifierSequence);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(issuerTradeIdModel, _that.getIssuerTradeIdModel())) return false;
			if (!Objects.equals(tradeIdentifierSequence, _that.getTradeIdentifierSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerTradeIdModel != null ? issuerTradeIdModel.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifierSequence != null ? tradeIdentifierSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifier {" +
				"issuerTradeIdModel=" + this.issuerTradeIdModel + ", " +
				"tradeIdentifierSequence=" + this.tradeIdentifierSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeIdentifier  ***********************/
	class TradeIdentifierBuilderImpl implements TradeIdentifier.TradeIdentifierBuilder {
	
		protected IssuerTradeIdModel.IssuerTradeIdModelBuilder issuerTradeIdModel;
		protected TradeIdentifierSequence.TradeIdentifierSequenceBuilder tradeIdentifierSequence;
		protected String id;
	
		public TradeIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder getIssuerTradeIdModel() {
			return issuerTradeIdModel;
		}
		
		@Override
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder getOrCreateIssuerTradeIdModel() {
			IssuerTradeIdModel.IssuerTradeIdModelBuilder result;
			if (issuerTradeIdModel!=null) {
				result = issuerTradeIdModel;
			}
			else {
				result = issuerTradeIdModel = IssuerTradeIdModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierSequence")
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder getTradeIdentifierSequence() {
			return tradeIdentifierSequence;
		}
		
		@Override
		public TradeIdentifierSequence.TradeIdentifierSequenceBuilder getOrCreateTradeIdentifierSequence() {
			TradeIdentifierSequence.TradeIdentifierSequenceBuilder result;
			if (tradeIdentifierSequence!=null) {
				result = tradeIdentifierSequence;
			}
			else {
				result = tradeIdentifierSequence = TradeIdentifierSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public TradeIdentifier.TradeIdentifierBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel) {
			this.issuerTradeIdModel = issuerTradeIdModel==null?null:issuerTradeIdModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifierSequence")
		public TradeIdentifier.TradeIdentifierBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence) {
			this.tradeIdentifierSequence = tradeIdentifierSequence==null?null:tradeIdentifierSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TradeIdentifier.TradeIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public TradeIdentifier build() {
			return new TradeIdentifier.TradeIdentifierImpl(this);
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder prune() {
			if (issuerTradeIdModel!=null && !issuerTradeIdModel.prune().hasData()) issuerTradeIdModel = null;
			if (tradeIdentifierSequence!=null && !tradeIdentifierSequence.prune().hasData()) tradeIdentifierSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerTradeIdModel()!=null && getIssuerTradeIdModel().hasData()) return true;
			if (getTradeIdentifierSequence()!=null && getTradeIdentifierSequence().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeIdentifier.TradeIdentifierBuilder o = (TradeIdentifier.TradeIdentifierBuilder) other;
			
			merger.mergeRosetta(getIssuerTradeIdModel(), o.getIssuerTradeIdModel(), this::setIssuerTradeIdModel);
			merger.mergeRosetta(getTradeIdentifierSequence(), o.getTradeIdentifierSequence(), this::setTradeIdentifierSequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(issuerTradeIdModel, _that.getIssuerTradeIdModel())) return false;
			if (!Objects.equals(tradeIdentifierSequence, _that.getTradeIdentifierSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerTradeIdModel != null ? issuerTradeIdModel.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifierSequence != null ? tradeIdentifierSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierBuilder {" +
				"issuerTradeIdModel=" + this.issuerTradeIdModel + ", " +
				"tradeIdentifierSequence=" + this.tradeIdentifierSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
