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
import fpml.confirmation.IssuerId;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.IssuerTradeIdModel.IssuerTradeIdModelBuilder;
import fpml.confirmation.IssuerTradeIdModel.IssuerTradeIdModelBuilderImpl;
import fpml.confirmation.IssuerTradeIdModel.IssuerTradeIdModelImpl;
import fpml.confirmation.TradeId;
import fpml.confirmation.meta.IssuerTradeIdModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group for a two part identifier such as a USI.
 * @version ${project.version}
 */
@RosettaDataType(value="IssuerTradeIdModel", builder=IssuerTradeIdModel.IssuerTradeIdModelBuilderImpl.class, version="${project.version}")
public interface IssuerTradeIdModel extends RosettaModelObject {

	IssuerTradeIdModelMeta metaData = new IssuerTradeIdModelMeta();

	/*********************** Getter Methods  ***********************/
	IssuerId getIssuer();
	TradeId getTradeId();

	/*********************** Build Methods  ***********************/
	IssuerTradeIdModel build();
	
	IssuerTradeIdModel.IssuerTradeIdModelBuilder toBuilder();
	
	static IssuerTradeIdModel.IssuerTradeIdModelBuilder builder() {
		return new IssuerTradeIdModel.IssuerTradeIdModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerTradeIdModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IssuerTradeIdModel> getType() {
		return IssuerTradeIdModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerTradeIdModelBuilder extends IssuerTradeIdModel, RosettaModelObjectBuilder {
		IssuerId.IssuerIdBuilder getOrCreateIssuer();
		IssuerId.IssuerIdBuilder getIssuer();
		TradeId.TradeIdBuilder getOrCreateTradeId();
		TradeId.TradeIdBuilder getTradeId();
		IssuerTradeIdModel.IssuerTradeIdModelBuilder setIssuer(IssuerId issuer);
		IssuerTradeIdModel.IssuerTradeIdModelBuilder setTradeId(TradeId tradeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
		}
		

		IssuerTradeIdModel.IssuerTradeIdModelBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerTradeIdModel  ***********************/
	class IssuerTradeIdModelImpl implements IssuerTradeIdModel {
		private final IssuerId issuer;
		private final TradeId tradeId;
		
		protected IssuerTradeIdModelImpl(IssuerTradeIdModel.IssuerTradeIdModelBuilder builder) {
			this.issuer = ofNullable(builder.getIssuer()).map(f->f.build()).orElse(null);
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuer")
		public IssuerId getIssuer() {
			return issuer;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		public IssuerTradeIdModel build() {
			return this;
		}
		
		@Override
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder toBuilder() {
			IssuerTradeIdModel.IssuerTradeIdModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerTradeIdModel.IssuerTradeIdModelBuilder builder) {
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeIdModel _that = getType().cast(o);
		
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeIdModel {" +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerTradeIdModel  ***********************/
	class IssuerTradeIdModelBuilderImpl implements IssuerTradeIdModel.IssuerTradeIdModelBuilder {
	
		protected IssuerId.IssuerIdBuilder issuer;
		protected TradeId.TradeIdBuilder tradeId;
	
		public IssuerTradeIdModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuer")
		public IssuerId.IssuerIdBuilder getIssuer() {
			return issuer;
		}
		
		@Override
		public IssuerId.IssuerIdBuilder getOrCreateIssuer() {
			IssuerId.IssuerIdBuilder result;
			if (issuer!=null) {
				result = issuer;
			}
			else {
				result = issuer = IssuerId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuer")
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder setIssuer(IssuerId issuer) {
			this.issuer = issuer==null?null:issuer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeId")
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder setTradeId(TradeId tradeId) {
			this.tradeId = tradeId==null?null:tradeId.toBuilder();
			return this;
		}
		
		@Override
		public IssuerTradeIdModel build() {
			return new IssuerTradeIdModel.IssuerTradeIdModelImpl(this);
		}
		
		@Override
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder prune() {
			if (issuer!=null && !issuer.prune().hasData()) issuer = null;
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuer()!=null && getIssuer().hasData()) return true;
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeIdModel.IssuerTradeIdModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerTradeIdModel.IssuerTradeIdModelBuilder o = (IssuerTradeIdModel.IssuerTradeIdModelBuilder) other;
			
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::setIssuer);
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeIdModel _that = getType().cast(o);
		
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeIdModelBuilder {" +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId +
			'}';
		}
	}
}
