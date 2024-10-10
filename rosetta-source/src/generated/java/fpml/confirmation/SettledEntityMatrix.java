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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.MatrixSource;
import fpml.confirmation.SettledEntityMatrix;
import fpml.confirmation.SettledEntityMatrix.SettledEntityMatrixBuilder;
import fpml.confirmation.SettledEntityMatrix.SettledEntityMatrixBuilderImpl;
import fpml.confirmation.SettledEntityMatrix.SettledEntityMatrixImpl;
import fpml.confirmation.meta.SettledEntityMatrixMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettledEntityMatrix", builder=SettledEntityMatrix.SettledEntityMatrixBuilderImpl.class, version="${project.version}")
public interface SettledEntityMatrix extends RosettaModelObject {

	SettledEntityMatrixMeta metaData = new SettledEntityMatrixMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Relevant settled entity matrix source.
	 */
	MatrixSource getMatrixSource();
	/**
	 * Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
	 */
	Date getPublicationDate();

	/*********************** Build Methods  ***********************/
	SettledEntityMatrix build();
	
	SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder();
	
	static SettledEntityMatrix.SettledEntityMatrixBuilder builder() {
		return new SettledEntityMatrix.SettledEntityMatrixBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettledEntityMatrix> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettledEntityMatrix> getType() {
		return SettledEntityMatrix.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("matrixSource"), processor, MatrixSource.class, getMatrixSource());
		processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettledEntityMatrixBuilder extends SettledEntityMatrix, RosettaModelObjectBuilder {
		MatrixSource.MatrixSourceBuilder getOrCreateMatrixSource();
		MatrixSource.MatrixSourceBuilder getMatrixSource();
		SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSource(MatrixSource matrixSource);
		SettledEntityMatrix.SettledEntityMatrixBuilder setPublicationDate(Date publicationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("matrixSource"), processor, MatrixSource.MatrixSourceBuilder.class, getMatrixSource());
			processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
		}
		

		SettledEntityMatrix.SettledEntityMatrixBuilder prune();
	}

	/*********************** Immutable Implementation of SettledEntityMatrix  ***********************/
	class SettledEntityMatrixImpl implements SettledEntityMatrix {
		private final MatrixSource matrixSource;
		private final Date publicationDate;
		
		protected SettledEntityMatrixImpl(SettledEntityMatrix.SettledEntityMatrixBuilder builder) {
			this.matrixSource = ofNullable(builder.getMatrixSource()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		@RosettaAttribute("matrixSource")
		public MatrixSource getMatrixSource() {
			return matrixSource;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public SettledEntityMatrix build() {
			return this;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder() {
			SettledEntityMatrix.SettledEntityMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettledEntityMatrix.SettledEntityMatrixBuilder builder) {
			ofNullable(getMatrixSource()).ifPresent(builder::setMatrixSource);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettledEntityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixSource, _that.getMatrixSource())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixSource != null ? matrixSource.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettledEntityMatrix {" +
				"matrixSource=" + this.matrixSource + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of SettledEntityMatrix  ***********************/
	class SettledEntityMatrixBuilderImpl implements SettledEntityMatrix.SettledEntityMatrixBuilder {
	
		protected MatrixSource.MatrixSourceBuilder matrixSource;
		protected Date publicationDate;
	
		public SettledEntityMatrixBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("matrixSource")
		public MatrixSource.MatrixSourceBuilder getMatrixSource() {
			return matrixSource;
		}
		
		@Override
		public MatrixSource.MatrixSourceBuilder getOrCreateMatrixSource() {
			MatrixSource.MatrixSourceBuilder result;
			if (matrixSource!=null) {
				result = matrixSource;
			}
			else {
				result = matrixSource = MatrixSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		@RosettaAttribute("matrixSource")
		public SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSource(MatrixSource matrixSource) {
			this.matrixSource = matrixSource==null?null:matrixSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("publicationDate")
		public SettledEntityMatrix.SettledEntityMatrixBuilder setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate==null?null:publicationDate;
			return this;
		}
		
		@Override
		public SettledEntityMatrix build() {
			return new SettledEntityMatrix.SettledEntityMatrixImpl(this);
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder prune() {
			if (matrixSource!=null && !matrixSource.prune().hasData()) matrixSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMatrixSource()!=null && getMatrixSource().hasData()) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettledEntityMatrix.SettledEntityMatrixBuilder o = (SettledEntityMatrix.SettledEntityMatrixBuilder) other;
			
			merger.mergeRosetta(getMatrixSource(), o.getMatrixSource(), this::setMatrixSource);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettledEntityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixSource, _that.getMatrixSource())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixSource != null ? matrixSource.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettledEntityMatrixBuilder {" +
				"matrixSource=" + this.matrixSource + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
