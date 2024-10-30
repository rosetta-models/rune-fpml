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
import fpml.confirmation.Rate;
import fpml.confirmation.Rate.RateBuilder;
import fpml.confirmation.Rate.RateBuilderImpl;
import fpml.confirmation.Rate.RateImpl;
import fpml.confirmation.meta.RateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The abstract base class for all types which define interest rate streams.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Rate", builder=Rate.RateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Rate extends RosettaModelObject {

	RateMeta metaData = new RateMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	Rate build();
	
	Rate.RateBuilder toBuilder();
	
	static Rate.RateBuilder builder() {
		return new Rate.RateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Rate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Rate> getType() {
		return Rate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateBuilder extends Rate, RosettaModelObjectBuilder {
		Rate.RateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Rate.RateBuilder prune();
	}

	/*********************** Immutable Implementation of Rate  ***********************/
	class RateImpl implements Rate {
		private final String id;
		
		protected RateImpl(Rate.RateBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Rate build() {
			return this;
		}
		
		@Override
		public Rate.RateBuilder toBuilder() {
			Rate.RateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Rate.RateBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Rate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Rate {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Rate  ***********************/
	class RateBuilderImpl implements Rate.RateBuilder {
	
		protected String id;
	
		public RateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public Rate.RateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Rate build() {
			return new Rate.RateImpl(this);
		}
		
		@Override
		public Rate.RateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rate.RateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rate.RateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Rate.RateBuilder o = (Rate.RateBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Rate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
