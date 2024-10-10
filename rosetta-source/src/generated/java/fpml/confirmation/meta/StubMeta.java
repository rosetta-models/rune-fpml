package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Stub;
import fpml.confirmation.validation.StubTypeFormatValidator;
import fpml.confirmation.validation.StubValidator;
import fpml.confirmation.validation.exists.StubOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Stub.class)
public class StubMeta implements RosettaMetaData<Stub> {

	@Override
	public List<Validator<? super Stub>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.StubValue>create(fpml.confirmation.validation.datarule.StubValueChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Stub, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Stub> validator() {
		return new StubValidator();
	}

	@Override
	public Validator<? super Stub> typeFormatValidator() {
		return new StubTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Stub, Set<String>> onlyExistsValidator() {
		return new StubOnlyExistsValidator();
	}
}
