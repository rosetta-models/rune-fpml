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
import fpml.confirmation.BidMidAskModel;
import fpml.confirmation.BidMidAskModel.BidMidAskModelBuilder;
import fpml.confirmation.BidMidAskModel.BidMidAskModelBuilderImpl;
import fpml.confirmation.BidMidAskModel.BidMidAskModelImpl;
import fpml.confirmation.meta.BidMidAskModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The bid, mid, or ask values relevant for a quote
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BidMidAskModel", builder=BidMidAskModel.BidMidAskModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BidMidAskModel extends RosettaModelObject {

	BidMidAskModelMeta metaData = new BidMidAskModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A price &quot;bid&quot; by a buyer for an asset, i.e. the price a buyer is willing to pay.
	 */
	BigDecimal getBid();
	/**
	 * A price midway between the bid and the ask price.
	 */
	BigDecimal getMid();
	/**
	 * A price &quot;asked&quot; by a seller for an asset, i.e. the price at which a seller is willing to sell.
	 */
	BigDecimal getAsk();

	/*********************** Build Methods  ***********************/
	BidMidAskModel build();
	
	BidMidAskModel.BidMidAskModelBuilder toBuilder();
	
	static BidMidAskModel.BidMidAskModelBuilder builder() {
		return new BidMidAskModel.BidMidAskModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BidMidAskModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BidMidAskModel> getType() {
		return BidMidAskModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bid"), BigDecimal.class, getBid(), this);
		processor.processBasic(path.newSubPath("mid"), BigDecimal.class, getMid(), this);
		processor.processBasic(path.newSubPath("ask"), BigDecimal.class, getAsk(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BidMidAskModelBuilder extends BidMidAskModel, RosettaModelObjectBuilder {
		BidMidAskModel.BidMidAskModelBuilder setBid(BigDecimal bid);
		BidMidAskModel.BidMidAskModelBuilder setMid(BigDecimal mid);
		BidMidAskModel.BidMidAskModelBuilder setAsk(BigDecimal ask);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("bid"), BigDecimal.class, getBid(), this);
			processor.processBasic(path.newSubPath("mid"), BigDecimal.class, getMid(), this);
			processor.processBasic(path.newSubPath("ask"), BigDecimal.class, getAsk(), this);
		}
		

		BidMidAskModel.BidMidAskModelBuilder prune();
	}

	/*********************** Immutable Implementation of BidMidAskModel  ***********************/
	class BidMidAskModelImpl implements BidMidAskModel {
		private final BigDecimal bid;
		private final BigDecimal mid;
		private final BigDecimal ask;
		
		protected BidMidAskModelImpl(BidMidAskModel.BidMidAskModelBuilder builder) {
			this.bid = builder.getBid();
			this.mid = builder.getMid();
			this.ask = builder.getAsk();
		}
		
		@Override
		@RosettaAttribute("bid")
		public BigDecimal getBid() {
			return bid;
		}
		
		@Override
		@RosettaAttribute("mid")
		public BigDecimal getMid() {
			return mid;
		}
		
		@Override
		@RosettaAttribute("ask")
		public BigDecimal getAsk() {
			return ask;
		}
		
		@Override
		public BidMidAskModel build() {
			return this;
		}
		
		@Override
		public BidMidAskModel.BidMidAskModelBuilder toBuilder() {
			BidMidAskModel.BidMidAskModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BidMidAskModel.BidMidAskModelBuilder builder) {
			ofNullable(getBid()).ifPresent(builder::setBid);
			ofNullable(getMid()).ifPresent(builder::setMid);
			ofNullable(getAsk()).ifPresent(builder::setAsk);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BidMidAskModel _that = getType().cast(o);
		
			if (!Objects.equals(bid, _that.getBid())) return false;
			if (!Objects.equals(mid, _that.getMid())) return false;
			if (!Objects.equals(ask, _that.getAsk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bid != null ? bid.hashCode() : 0);
			_result = 31 * _result + (mid != null ? mid.hashCode() : 0);
			_result = 31 * _result + (ask != null ? ask.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BidMidAskModel {" +
				"bid=" + this.bid + ", " +
				"mid=" + this.mid + ", " +
				"ask=" + this.ask +
			'}';
		}
	}

	/*********************** Builder Implementation of BidMidAskModel  ***********************/
	class BidMidAskModelBuilderImpl implements BidMidAskModel.BidMidAskModelBuilder {
	
		protected BigDecimal bid;
		protected BigDecimal mid;
		protected BigDecimal ask;
	
		public BidMidAskModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bid")
		public BigDecimal getBid() {
			return bid;
		}
		
		@Override
		@RosettaAttribute("mid")
		public BigDecimal getMid() {
			return mid;
		}
		
		@Override
		@RosettaAttribute("ask")
		public BigDecimal getAsk() {
			return ask;
		}
		
		@Override
		@RosettaAttribute("bid")
		public BidMidAskModel.BidMidAskModelBuilder setBid(BigDecimal bid) {
			this.bid = bid==null?null:bid;
			return this;
		}
		@Override
		@RosettaAttribute("mid")
		public BidMidAskModel.BidMidAskModelBuilder setMid(BigDecimal mid) {
			this.mid = mid==null?null:mid;
			return this;
		}
		@Override
		@RosettaAttribute("ask")
		public BidMidAskModel.BidMidAskModelBuilder setAsk(BigDecimal ask) {
			this.ask = ask==null?null:ask;
			return this;
		}
		
		@Override
		public BidMidAskModel build() {
			return new BidMidAskModel.BidMidAskModelImpl(this);
		}
		
		@Override
		public BidMidAskModel.BidMidAskModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BidMidAskModel.BidMidAskModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBid()!=null) return true;
			if (getMid()!=null) return true;
			if (getAsk()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BidMidAskModel.BidMidAskModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BidMidAskModel.BidMidAskModelBuilder o = (BidMidAskModel.BidMidAskModelBuilder) other;
			
			
			merger.mergeBasic(getBid(), o.getBid(), this::setBid);
			merger.mergeBasic(getMid(), o.getMid(), this::setMid);
			merger.mergeBasic(getAsk(), o.getAsk(), this::setAsk);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BidMidAskModel _that = getType().cast(o);
		
			if (!Objects.equals(bid, _that.getBid())) return false;
			if (!Objects.equals(mid, _that.getMid())) return false;
			if (!Objects.equals(ask, _that.getAsk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bid != null ? bid.hashCode() : 0);
			_result = 31 * _result + (mid != null ? mid.hashCode() : 0);
			_result = 31 * _result + (ask != null ? ask.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BidMidAskModelBuilder {" +
				"bid=" + this.bid + ", " +
				"mid=" + this.mid + ", " +
				"ask=" + this.ask +
			'}';
		}
	}
}
