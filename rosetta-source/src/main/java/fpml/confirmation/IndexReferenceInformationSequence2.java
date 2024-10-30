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
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.IndexReferenceInformationSequence2;
import fpml.confirmation.IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder;
import fpml.confirmation.IndexReferenceInformationSequence2.IndexReferenceInformationSequence2BuilderImpl;
import fpml.confirmation.IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Impl;
import fpml.confirmation.meta.IndexReferenceInformationSequence2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="IndexReferenceInformationSequence2", builder=IndexReferenceInformationSequence2.IndexReferenceInformationSequence2BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface IndexReferenceInformationSequence2 extends RosettaModelObject {

	IndexReferenceInformationSequence2Meta metaData = new IndexReferenceInformationSequence2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
	 */
	BigDecimal getIndexFactor();
	/**
	 * Seniority of debt instruments comprising the index.
	 */
	CreditSeniority getSeniority();

	/*********************** Build Methods  ***********************/
	IndexReferenceInformationSequence2 build();
	
	IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder toBuilder();
	
	static IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder builder() {
		return new IndexReferenceInformationSequence2.IndexReferenceInformationSequence2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexReferenceInformationSequence2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexReferenceInformationSequence2> getType() {
		return IndexReferenceInformationSequence2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexReferenceInformationSequence2Builder extends IndexReferenceInformationSequence2, RosettaModelObjectBuilder {
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder setIndexFactor(BigDecimal indexFactor);
		IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder setSeniority(CreditSeniority seniority);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
		}
		

		IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder prune();
	}

	/*********************** Immutable Implementation of IndexReferenceInformationSequence2  ***********************/
	class IndexReferenceInformationSequence2Impl implements IndexReferenceInformationSequence2 {
		private final BigDecimal indexFactor;
		private final CreditSeniority seniority;
		
		protected IndexReferenceInformationSequence2Impl(IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder builder) {
			this.indexFactor = builder.getIndexFactor();
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		public IndexReferenceInformationSequence2 build() {
			return this;
		}
		
		@Override
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder toBuilder() {
			IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder builder) {
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformationSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationSequence2 {" +
				"indexFactor=" + this.indexFactor + ", " +
				"seniority=" + this.seniority +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexReferenceInformationSequence2  ***********************/
	class IndexReferenceInformationSequence2BuilderImpl implements IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder {
	
		protected BigDecimal indexFactor;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
	
		public IndexReferenceInformationSequence2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder setIndexFactor(BigDecimal indexFactor) {
			this.indexFactor = indexFactor==null?null:indexFactor;
			return this;
		}
		@Override
		@RosettaAttribute("seniority")
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder setSeniority(CreditSeniority seniority) {
			this.seniority = seniority==null?null:seniority.toBuilder();
			return this;
		}
		
		@Override
		public IndexReferenceInformationSequence2 build() {
			return new IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Impl(this);
		}
		
		@Override
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder prune() {
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexFactor()!=null) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder o = (IndexReferenceInformationSequence2.IndexReferenceInformationSequence2Builder) other;
			
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformationSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationSequence2Builder {" +
				"indexFactor=" + this.indexFactor + ", " +
				"seniority=" + this.seniority +
			'}';
		}
	}
}
