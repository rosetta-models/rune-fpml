package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.X509Data;
import fpml.confirmation.validation.X509DataTypeFormatValidator;
import fpml.confirmation.validation.X509DataValidator;
import fpml.confirmation.validation.exists.X509DataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=X509Data.class)
public class X509DataMeta implements RosettaMetaData<X509Data> {

	@Override
	public List<Validator<? super X509Data>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super X509Data, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super X509Data> validator() {
		return new X509DataValidator();
	}

	@Override
	public Validator<? super X509Data> typeFormatValidator() {
		return new X509DataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509Data, Set<String>> onlyExistsValidator() {
		return new X509DataOnlyExistsValidator();
	}
}
