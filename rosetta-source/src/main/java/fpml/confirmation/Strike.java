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
import fpml.confirmation.IdentifiedPayerReceiver;
import fpml.confirmation.Strike;
import fpml.confirmation.Strike.StrikeBuilder;
import fpml.confirmation.Strike.StrikeBuilderImpl;
import fpml.confirmation.Strike.StrikeImpl;
import fpml.confirmation.meta.StrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a single cap or floor rate.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Strike", builder=Strike.StrikeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Strike extends RosettaModelObject {

	StrikeMeta metaData = new StrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate for a cap or floor.
	 */
	BigDecimal getStrikeRate();
	/**
	 * The buyer of the option
	 */
	IdentifiedPayerReceiver getBuyer();
	/**
	 * The party that has sold.
	 */
	IdentifiedPayerReceiver getSeller();
	String getId();

	/*********************** Build Methods  ***********************/
	Strike build();
	
	Strike.StrikeBuilder toBuilder();
	
	static Strike.StrikeBuilder builder() {
		return new Strike.StrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Strike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Strike> getType() {
		return Strike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikeRate"), BigDecimal.class, getStrikeRate(), this);
		processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.class, getBuyer());
		processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.class, getSeller());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikeBuilder extends Strike, RosettaModelObjectBuilder {
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller();
		Strike.StrikeBuilder setStrikeRate(BigDecimal strikeRate);
		Strike.StrikeBuilder setBuyer(IdentifiedPayerReceiver buyer);
		Strike.StrikeBuilder setSeller(IdentifiedPayerReceiver seller);
		Strike.StrikeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikeRate"), BigDecimal.class, getStrikeRate(), this);
			processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getBuyer());
			processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getSeller());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Strike.StrikeBuilder prune();
	}

	/*********************** Immutable Implementation of Strike  ***********************/
	class StrikeImpl implements Strike {
		private final BigDecimal strikeRate;
		private final IdentifiedPayerReceiver buyer;
		private final IdentifiedPayerReceiver seller;
		private final String id;
		
		protected StrikeImpl(Strike.StrikeBuilder builder) {
			this.strikeRate = builder.getStrikeRate();
			this.buyer = ofNullable(builder.getBuyer()).map(f->f.build()).orElse(null);
			this.seller = ofNullable(builder.getSeller()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("strikeRate")
		public BigDecimal getStrikeRate() {
			return strikeRate;
		}
		
		@Override
		@RosettaAttribute("buyer")
		public IdentifiedPayerReceiver getBuyer() {
			return buyer;
		}
		
		@Override
		@RosettaAttribute("seller")
		public IdentifiedPayerReceiver getSeller() {
			return seller;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Strike build() {
			return this;
		}
		
		@Override
		public Strike.StrikeBuilder toBuilder() {
			Strike.StrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Strike.StrikeBuilder builder) {
			ofNullable(getStrikeRate()).ifPresent(builder::setStrikeRate);
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Strike _that = getType().cast(o);
		
			if (!Objects.equals(strikeRate, _that.getStrikeRate())) return false;
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikeRate != null ? strikeRate.hashCode() : 0);
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Strike {" +
				"strikeRate=" + this.strikeRate + ", " +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Strike  ***********************/
	class StrikeBuilderImpl implements Strike.StrikeBuilder {
	
		protected BigDecimal strikeRate;
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder buyer;
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder seller;
		protected String id;
	
		public StrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikeRate")
		public BigDecimal getStrikeRate() {
			return strikeRate;
		}
		
		@Override
		@RosettaAttribute("buyer")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer() {
			return buyer;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (buyer!=null) {
				result = buyer;
			}
			else {
				result = buyer = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seller")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller() {
			return seller;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (seller!=null) {
				result = seller;
			}
			else {
				result = seller = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("strikeRate")
		public Strike.StrikeBuilder setStrikeRate(BigDecimal strikeRate) {
			this.strikeRate = strikeRate==null?null:strikeRate;
			return this;
		}
		@Override
		@RosettaAttribute("buyer")
		public Strike.StrikeBuilder setBuyer(IdentifiedPayerReceiver buyer) {
			this.buyer = buyer==null?null:buyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("seller")
		public Strike.StrikeBuilder setSeller(IdentifiedPayerReceiver seller) {
			this.seller = seller==null?null:seller.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Strike.StrikeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Strike build() {
			return new Strike.StrikeImpl(this);
		}
		
		@Override
		public Strike.StrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strike.StrikeBuilder prune() {
			if (buyer!=null && !buyer.prune().hasData()) buyer = null;
			if (seller!=null && !seller.prune().hasData()) seller = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikeRate()!=null) return true;
			if (getBuyer()!=null && getBuyer().hasData()) return true;
			if (getSeller()!=null && getSeller().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strike.StrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Strike.StrikeBuilder o = (Strike.StrikeBuilder) other;
			
			merger.mergeRosetta(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeRosetta(getSeller(), o.getSeller(), this::setSeller);
			
			merger.mergeBasic(getStrikeRate(), o.getStrikeRate(), this::setStrikeRate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Strike _that = getType().cast(o);
		
			if (!Objects.equals(strikeRate, _that.getStrikeRate())) return false;
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikeRate != null ? strikeRate.hashCode() : 0);
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeBuilder {" +
				"strikeRate=" + this.strikeRate + ", " +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
